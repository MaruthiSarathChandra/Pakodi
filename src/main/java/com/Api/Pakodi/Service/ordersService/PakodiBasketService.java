package com.Api.Pakodi.Service.ordersService;


import com.Api.Pakodi.Repository.itemsRepo.MenuRepo;
import com.Api.Pakodi.Repository.ordersRepo.BasketItemsRepo;
import com.Api.Pakodi.Repository.ordersRepo.PakodiBasketRepo;
import com.Api.Pakodi.Service.DateTime;
import com.Api.Pakodi.Service.Maths;
import com.Api.Pakodi.domain.items.Menu;
import com.Api.Pakodi.domain.items.Restaurant;
import com.Api.Pakodi.domain.order.BasketItems;
import com.Api.Pakodi.domain.order.PakodiBasket;
import com.Api.Pakodi.request.dto.BasketItemsRequest;
import com.Api.Pakodi.request.dto.DeleteItem;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Component
public class PakodiBasketService {


    @Autowired
    private PakodiBasketRepo pakodiBasketRepo;

    @Autowired
    private BasketItemsService basketItemsService;

    @Autowired
    private DateTime localDateTime;

    @Autowired
    private Maths maths;

    @Autowired
    private BasketItemsRepo basketItemsRepo;

    @Autowired
    private MenuRepo menuRepo;





    /*
    1. Account Exist
    2. Create, Read, Updata, Delete
    */




    // Create Operation
    @Transactional
    public boolean addToPakodiBasket(BasketItemsRequest basketItems, String sessionIdArg, String gmailidd) {


        // Feilds Extraction From BasketItemsRequest Object

        //String gmailId  = basketItems.getGmailId();
        String gmailId = gmailidd;
        String sessionId = sessionIdArg;
        Menu menu = basketItems.getMenuId();
        Long quantity = basketItems.getQuantity();


        String couponCode = "abc";



        Optional<Menu> resInMenu = getMenuById(menu);
        BigDecimal price = resInMenu.get().getPrice();
        Restaurant restaurant = resInMenu.get().getRestaurantId();





        // Tax Calculation
        List<BigDecimal> list = maths.afterTaxBeforeAmount(price, quantity);
        BigDecimal taxAmount = list.get(0);
        BigDecimal afterTax = list.get(1);




        // I. Checking if a row exist with restaurant and gmailId (Search Query)
        List<PakodiBasket> resInPB = getResturantByGmaild(gmailId, restaurant);



        try {
            if(!resInPB.isEmpty()) {

                // 1 Updates the TOTAL amount if an order already exists for the specified restaurant.
                putTotalByGmailIdAndRestaurant(gmailId, restaurant.getId(), afterTax);


                // 1.1 checking whether the menu(item) exist or not in basketItems.
                BasketItems resInBI = basketItemsRepo.findByGmailIdAndMenuId(gmailId, menu);

                if(resInBI != null) {

                    // 1.2 Updating Existing BasketItems Entity
                    basketItemsService.putQuantityAndTaxAndTotalByGmailIdAndMenuIdAndRestaurant(
                            gmailId,
                            menu,
                            taxAmount,
                            afterTax,
                            quantity);

                } else {
                    // 1.3 Adding BasketItems Entity
                    basketItemsService.addBasketItems(resInPB.get(0), gmailId, sessionId,
                            menu, quantity, price, couponCode, taxAmount, afterTax);

                }
            } else {


                // 2. Creates a PakodiBasket entity and saves it if no record exists for the user with the specified restaurant.
                LocalDateTime createdAt = localDateTime.getDateTime();
                LocalDateTime expiresAt = localDateTime.getExpiringDateTime(createdAt);
                PakodiBasket pakodiBasket = new PakodiBasket();
                pakodiBasket.setGmailId(gmailId);
                pakodiBasket.setSessionId(sessionId);
                pakodiBasket.setCreatedAt(createdAt);
                pakodiBasket.setExpiresAt(expiresAt);
                pakodiBasket.setRestaurant(restaurant);
                pakodiBasket.setTotal(afterTax);

                // Saving the entity Object to DataBase
                pakodiBasketRepo.save(pakodiBasket);


                // 2.1 Adding BasketItems Entity
                basketItemsService.addBasketItems(pakodiBasket, gmailId, sessionId,
                        menu, quantity, price, couponCode, taxAmount, afterTax);
            }

            return true;

        } catch (Exception e) {

            return false;
        }
    }


    /*
    * NOTE: 2. Read Operation
    * THIS TABLE DON'T REQUIRE ANY READ OPERATION UNTIL IF TRANSCATION TOTALAMOUNT IS CALCULATED FORM THIS TABLE.
    */
    public List<PakodiBasket> findByGmailId(String gmailId) {

        return pakodiBasketRepo.findByGmailId(gmailId);
    }



    // 3. Update Operation
    public void putTotalByGmailIdAndRestaurant(String gmailId, Long restaurant, BigDecimal afterTax){
        System.out.println("Entered");
        pakodiBasketRepo.updateTotalByGmailIdAndRestaurant(gmailId, restaurant, afterTax);
    }



    // 4. Delete Operation
    @Transactional
    public void deleteItem(String gmailId, Menu menu, Restaurant restaurant) {

        basketItemsService.deleteItemByGmailIdAndMenuId(gmailId, menu);
        pakodiBasketRepo.deleteByGmailIdAndRestaurant(gmailId, restaurant);
    }

    @Transactional
    public int deleteBasket(String gmailId) {
        return pakodiBasketRepo.deleteByGmailId(gmailId);
    }



    // 5. Find Operation: To Check whether a row exist belongs to gmailId with Resturant.
    public List<PakodiBasket> getResturantByGmaild(String gmailId, Restaurant restaurant) {

        return pakodiBasketRepo.findByGmailIdAndRestaurant(gmailId, restaurant);

    }

    // 6. Get Operation: To get the Price
    public Optional<Menu> getMenuById(Menu menu) {
        return menuRepo.findById(menu.getId());
    }


}

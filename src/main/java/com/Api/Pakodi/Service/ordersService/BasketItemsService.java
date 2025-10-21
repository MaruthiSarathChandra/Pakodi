package com.Api.Pakodi.Service.ordersService;

import com.Api.Pakodi.Repository.ordersRepo.BasketItemsRepo;
import com.Api.Pakodi.domain.items.Menu;
import com.Api.Pakodi.domain.items.Restaurant;
import com.Api.Pakodi.domain.order.BasketItems;
import com.Api.Pakodi.domain.order.PakodiBasket;
import com.Api.Pakodi.request.dto.BasketItemsRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class BasketItemsService {

    @Autowired
    private BasketItemsRepo basketItemsRepo;



    // 1. Create Operation to create BasketItems
    public void addBasketItems(PakodiBasket pakodiBasket, String gmailId, String sessionId,
                                   Menu menuId, Long quantity, BigDecimal price, String couponCode, BigDecimal taxAmount, BigDecimal afterTax) {


        BasketItems response = basketItemsRepo.findByGmailIdAndMenuId(gmailId, menuId);

        if(response != null) {

            basketItemsRepo.updateQuantityAndTaxAndTotalByGmailIdAndMenuId(gmailId, menuId.getId(), taxAmount, quantity, taxAmount);


        } else {

            //2. BasketItems Entity Object Creation with the UserData

            BasketItems basketItems = new BasketItems();
            basketItems.setPakodiBasket(pakodiBasket);
            basketItems.setGmailId(gmailId);
            basketItems.setMenuId(menuId);
            basketItems.setQuantity(quantity);
            basketItems.setPrice(price);
            basketItems.setCouponCode(String.valueOf(couponCode));


            basketItems.setTax(taxAmount);
            basketItems.setTotal(afterTax);


            // Saving the entity Object to DataBase
            basketItemsRepo.save(basketItems);

        }
    }


    // 2. Read Operation to get BasketItems
    public List<BasketItems> getBasketItemsByGmailId(String gmailId) {

        return basketItemsRepo.getBasketItemsByGmailId(gmailId);
    }





    // 3. Put Operation to change tax, quantity, Total
    public void putQuantityAndTaxAndTotalByGmailIdAndMenuIdAndRestaurant(String gmailId, Menu menuId,
                                                                      BigDecimal taxAmount, BigDecimal total, Long quantity) {

        basketItemsRepo.updateQuantityAndTaxAndTotalByGmailIdAndMenuId(
                gmailId,
                menuId.getId(),
                total,
                quantity,
                taxAmount);
    }


    // 4. Delete Operation
    @Transactional
    public int deleteItemByGmailIdAndMenuId(String gmailId, Menu menuId) {

        return basketItemsRepo.deleteByGmailIdAndMenuId(gmailId, menuId);
    }

    @Transactional
    public int deleteBasketItems(String gmailId) {
        return basketItemsRepo.deleteByGmailId(gmailId);
    }



    // 2. Reading for webpage
    //purpose: it just fetch the user data from the cart. to display image and
    public List<BasketItemsRequest> getBasketItemsRequestByGmailId(String gmailId) {

        List<BasketItems> basketRequest = getBasketItemsByGmailId(gmailId);

        List<BasketItemsRequest> basketItemsResponse = new ArrayList<>();

        BasketItemsRequest basketItemsRequest = new BasketItemsRequest();


        for(BasketItems items: basketRequest){

            basketItemsRequest.setRestaurant(items.getMenuId().getRestaurantId());
            basketItemsRequest.setMenuId(items.getMenuId());
            basketItemsRequest.setQuantity(items.getQuantity());
            basketItemsRequest.setPrice(items.getPrice());
            basketItemsRequest.setCouponCode(items.getCouponCode());
            basketItemsResponse.add(basketItemsRequest);
        }


        return basketItemsResponse;
    }



}

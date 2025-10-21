package com.Api.Pakodi.Service.ordersService;

import com.Api.Pakodi.Repository.ordersRepo.OrdersItemsRepo;
import com.Api.Pakodi.Repository.ordersRepo.PakodiOrdersRepo;
import com.Api.Pakodi.Service.DateTime;
import com.Api.Pakodi.domain.items.Menu;
import com.Api.Pakodi.domain.items.Restaurant;
import com.Api.Pakodi.domain.order.BasketItems;
import com.Api.Pakodi.domain.order.OrdersItems;
import com.Api.Pakodi.domain.order.PakodiBasket;
import com.Api.Pakodi.domain.order.PakodiOrders;
import com.Api.Pakodi.enums.PakodiOrderStatus;
import com.Api.Pakodi.request.dto.BasketItemsRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Service
@Transactional
public class CheckOutService {

    /*
    * Get the Success
    *
    * Append all the PakodiBasket and BasketItems to PakodiOrders and OrdersItems
    *
    * Drop from PakodiBasket and BasketItems
    *
    * Let the Restaruant Prepare the Order
    *
    * Assign the Dasher
    *
    * Order Completed
    */
    @Autowired
    private PakodiBasketService pakodiBasketService;


    private List<PakodiBasket> validateCart(String userId) {

        List<PakodiBasket> items = pakodiBasketService.findByGmailId(userId);

        return items;
    }



    @Autowired
    private BasketItemsService basketItemsService;
    @Autowired
    private DateTime dateTime;
    @Autowired
    private PakodiOrdersRepo pakodiOrdersRepo;
    @Autowired
    private OrdersItemsRepo ordersItemsRepo;



    // 1. CheckOut

    public String checkOutService(String gmailId) {

        List<PakodiBasket> pakodiBaskets = validateCart(gmailId);

        if(pakodiBaskets.isEmpty()) {

            return "Cart is Empty";

        } else {

            List<BasketItems> basketItems = basketItemsService.getBasketItemsByGmailId(gmailId);


            HashMap<Long, PakodiOrders> hashMap = new HashMap<>();


            for(PakodiBasket item: pakodiBaskets) {

                PakodiOrders pakodiOrders = new PakodiOrders();

                pakodiOrders.setGmailId(item.getGmailId());
                pakodiOrders.setRestaurant(item.getRestaurant());
                pakodiOrders.setTotal(item.getTotal());
                pakodiOrders.setOrderStatus(PakodiOrderStatus.Placed);
                pakodiOrders.setPlacedAt(dateTime.getDateTime());

                pakodiOrdersRepo.save(pakodiOrders);

                hashMap.put(item.getRestaurant().getId(), pakodiOrders);

            }



            for(BasketItems item: basketItems) {

                OrdersItems ordersItems = new OrdersItems();

                ordersItems.setPakodiOrders(hashMap.get(item.getMenuId().getRestaurantId().getId()));
                ordersItems.setGmailId(item.getGmailId());
                ordersItems.setRestaurant(item.getMenuId().getRestaurantId());
                ordersItems.setMenu(item.getMenuId());
                ordersItems.setQuantity(item.getQuantity());
                ordersItems.setStatus(PakodiOrderStatus.Placed);
                ordersItems.setPlacedAt(dateTime.getDateTime());
                ordersItems.setCouponCode(item.getCouponCode());

                ordersItemsRepo.save(ordersItems);

            }
            basketItemsService.deleteBasketItems(gmailId);
            pakodiBasketService.deleteBasket(gmailId);

        }
        return "Success";
    }


}

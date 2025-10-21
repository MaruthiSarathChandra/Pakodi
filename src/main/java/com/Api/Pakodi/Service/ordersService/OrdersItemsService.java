package com.Api.Pakodi.Service.ordersService;

import com.Api.Pakodi.Repository.ordersRepo.OrdersItemsRepo;
import com.Api.Pakodi.Service.itemsService.MenuService;
import com.Api.Pakodi.domain.items.Menu;
import com.Api.Pakodi.domain.order.OrdersItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersItemsService {

    @Autowired
    private OrdersItemsRepo ordersItemsRepo;
    @Autowired
    private MenuService menuService;




    public List<OrdersItems> fetchOrders(String gmailId) {

        return ordersItemsRepo.findByGmailId(gmailId);


    }

    public List<Menu> getPastOrders(String gmailId) {


        List<Long> r = ordersItemsRepo.findMenuByGmailId(gmailId, "placed");

        List<Menu> response = new ArrayList<>();


        for (Object obj : r) {

            Long id = (Long) obj;

            response.add(menuService.getMenuById(id).get());
        }



        return response;

    }


}

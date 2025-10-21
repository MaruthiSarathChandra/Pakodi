package com.Api.Pakodi.Service.homeService;


import com.Api.Pakodi.Service.ordersService.OrdersItemsService;
import com.Api.Pakodi.domain.items.Menu;
import com.Api.Pakodi.domain.order.OrdersItems;
import com.Api.Pakodi.request.dto.GetPastOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

    @Autowired
    private OrdersItemsService ordersItemsService;

    public List<Menu> getPastOrders(String gmailId) {

        return ordersItemsService.getPastOrders(gmailId); // change the method name to pastOrders
    }


}

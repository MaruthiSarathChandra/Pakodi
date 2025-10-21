package com.Api.Pakodi.Controller.ordersController;


import com.Api.Pakodi.Service.ordersService.BasketItemsService;
import com.Api.Pakodi.Service.ordersService.PakodiBasketService;
import com.Api.Pakodi.domain.items.Restaurant;
import com.Api.Pakodi.domain.order.BasketItems;
import com.Api.Pakodi.domain.order.PakodiBasket;
import com.Api.Pakodi.request.dto.AddToCartRequest;
import com.Api.Pakodi.request.dto.BasketItemsRequest;
import com.Api.Pakodi.request.dto.DeleteItem;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequestMapping("/pakodi/api")
public class BasketController {

    @Autowired
    private PakodiBasketService pakodiBasketService;


    //1. Create And Update
    @PostMapping("/{gmailId}/add-to-cart")
    public void addtoCart(HttpServletRequest request, @PathVariable String gmailId, @RequestBody BasketItemsRequest basketItems){


        // Note: Code Change required "==" to "!="
        if(request.getSession().getAttribute("gmailId") == null) {
            pakodiBasketService.addToPakodiBasket(basketItems, request.getRemoteAddr(), gmailId);
        }
    }



    //Test 1 for addtocart
    @PostMapping("/add-to-cartt")
    public void addtoCartt(HttpServletRequest request, @RequestBody BasketItemsRequest addToCartRequest){

        // Note: Code Change required "==" to "!="
        System.out.println(addToCartRequest.getQuantity() + " " + addToCartRequest.getRestaurant() + " " + addToCartRequest.getMenuId());

        String user = (String) request.getSession().getAttribute("gmailId");

        pakodiBasketService.addToPakodiBasket(addToCartRequest, request.getRemoteAddr(), user);

    }






    // 2. Read
    @Autowired
    private BasketItemsService basketItemsService;

    @GetMapping("/basket")
    public ResponseEntity<List<BasketItemsRequest>> getBasketItems(HttpServletRequest request) {
        String user = (String) request.getSession().getAttribute("gmailId");
        //System.out.println("Fetching basket for user: hiiiiiii" + user.toLowerCase());
        //return basketItemsService.getBasketItemsByGmailId(user);
        return ResponseEntity.ok(basketItemsService.getBasketItemsRequestByGmailId(user));
    }


    // 3. Delete
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteItem(HttpServletRequest request, @RequestBody DeleteItem deleteItem) {
        try {
            String user = (String) request.getSession().getAttribute("gmailId");
            pakodiBasketService.deleteItem(user, deleteItem.getMenuId(), deleteItem.getRestaurant());
            return ResponseEntity.ok("Item deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.ok("some thing went wrong");
        }
    }



    // testing method i have used in the add to cart method in service layer.so, ignore after the full development. "Note: 2. Removing of method"
    @GetMapping("/{user}/{restaurantId}/check")
    public List<PakodiBasket> getCheck(@PathVariable String user, @PathVariable Restaurant restaurantId){
        return pakodiBasketService.getResturantByGmaild(user, restaurantId);
    }


}

package com.Api.Pakodi.request.dto;

import com.Api.Pakodi.domain.items.Menu;
import com.Api.Pakodi.domain.items.Restaurant;
import com.Api.Pakodi.domain.order.PakodiOrders;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class BasketItemsRequest {

    //private PakodiOrders pakodiOrders;

    private Restaurant restaurant;

    private Menu menuId;

    private Long quantity;

    private BigDecimal price; // u can get from menuId

    private String couponCode;



    /*
    public PakodiOrders getPakodiOrders() {
        return pakodiOrders;
    }

    public void setPakodiOrders(PakodiOrders pakodiOrders) {
        this.pakodiOrders = pakodiOrders;
    }*/

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }


    public Menu getMenuId() {
        return menuId;
    }

    public void setMenuId(Menu menuId) {
        this.menuId = menuId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }



    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

}

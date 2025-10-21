package com.Api.Pakodi.request.dto;


import com.Api.Pakodi.domain.items.Menu;
import com.Api.Pakodi.domain.items.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class AddToCartRequest {
    private Long quantity;
    private Restaurant restaurant;
    private Menu menuId;

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

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



}

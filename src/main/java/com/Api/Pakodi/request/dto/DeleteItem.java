package com.Api.Pakodi.request.dto;

import com.Api.Pakodi.domain.items.Menu;
import com.Api.Pakodi.domain.items.Restaurant;



public class DeleteItem {

    private Restaurant restaurantId;
    private Menu menuId;
    private String gmailId;




    // Getters and Setters

    public String getGmailId() {
        return gmailId;
    }

    public void setGmailId(String gmailId) {
        this.gmailId = gmailId;
    }

    public Menu getMenuId() {
        return menuId;
    }

    public void setMenuId(Menu menuId) {
        this.menuId = menuId;
    }

    public Restaurant getRestaurant() {
        return restaurantId;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurantId = restaurant;
    }

}

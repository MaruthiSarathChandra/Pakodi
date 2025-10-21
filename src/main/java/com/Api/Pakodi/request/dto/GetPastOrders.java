package com.Api.Pakodi.request.dto;

import com.Api.Pakodi.Service.ordersService.OrdersItemsService;
import com.Api.Pakodi.domain.items.Menu;
import com.Api.Pakodi.domain.items.Restaurant;
import com.Api.Pakodi.domain.order.OrdersItems;
import com.Api.Pakodi.domain.order.PakodiBasket;
import com.Api.Pakodi.enums.ItemType;
import com.Api.Pakodi.enums.MenuItemStatus;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Component
public class GetPastOrders {



    private Menu menuId;
    private Restaurant restaurantId;
    private String itemName;
    private BigDecimal price;
    private MenuItemStatus itemStatus;
    private ItemType itemType;
    private String Ingredients;
    private String image;





    public Menu getMenuId() {
        return menuId;
    }

    public void setMenuId(Menu menuId) {
        this.menuId = menuId;
    }

    public Restaurant getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Restaurant restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public MenuItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(MenuItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public String getIngredients() {
        return Ingredients;
    }

    public void setIngredients(String ingredients) {
        Ingredients = ingredients;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}

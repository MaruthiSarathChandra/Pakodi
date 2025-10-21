package com.Api.Pakodi.request.dto;

import com.Api.Pakodi.domain.items.Restaurant;
import com.Api.Pakodi.enums.ItemType;
import com.Api.Pakodi.enums.MenuItemStatus;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;





// 1. Data Transfer Object (DTO) that maps the Menu entity from MySQL to MenuRequest Java objects for JSON responses
@Component
public class MenuRequest {

    private Long Id;
    private Restaurant restaurantId;
    private String itemName;
    private BigDecimal price;
    private MenuItemStatus itemStatus;
    private ItemType itemType;
    private String Ingredients;
    private String image;

}

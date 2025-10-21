package com.Api.Pakodi.domain.items;


import com.Api.Pakodi.enums.ItemType;
import com.Api.Pakodi.enums.MenuItemStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurantId;

    @Column(name = "itemName", nullable = false)
    private String itemName;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "itemStatus", nullable = false)
    @Enumerated(EnumType.STRING)
    private MenuItemStatus itemStatus;

    @Column(name = "itemType", nullable = false)
    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    @Column(name = "ingredients")
    private String Ingredients;

    @Lob
    @Column(name = "stringImage")
    private String image;




    //Getters For Resturant Menu
    public Long getId() { return id;}

    public Restaurant getRestaurantId() {return restaurantId;}

    public String getItemName() {return itemName;}

    public BigDecimal getPrice() {return price;}

    public MenuItemStatus getItemStatus() {return itemStatus;}

    public ItemType getItemType() {return itemType;}

    public String getIngredients() {return Ingredients;}

    public String getImage() {return image;}

    //public List<NutrientsQuantity> getNutrientsQuantity() {return nutrientsQuantity;}
}

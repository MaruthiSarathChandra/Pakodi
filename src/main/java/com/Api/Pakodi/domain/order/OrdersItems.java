package com.Api.Pakodi.domain.order;

import com.Api.Pakodi.domain.items.Menu;
import com.Api.Pakodi.domain.items.Restaurant;
import com.Api.Pakodi.enums.PakodiOrderStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "OrdersItems")
public class OrdersItems {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "pakodiOrders", nullable = false)
    private PakodiOrders pakodiOrders;



    // GmailId is an Entity In future Change Registration to an Entity Table
    @Column(name = "gmailId", nullable = false)
    private String gmailId;

    @ManyToOne
    @JoinColumn(name = "restaurantId", nullable = false)
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "menuId", nullable = false)
    private Menu menu;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "orderStatus", nullable = false)
    private PakodiOrderStatus status;

    @Column(name = "placedAt", nullable = false)
    private LocalDateTime placedAt;

    @Column(name = "outForDeliveryAt", nullable = true)
    private LocalDateTime outForDeliveryAt;

    @Column(name = "deliveredAt", nullable = true)
    private LocalDateTime deliveredAt;

    @Column(name = "couponCode")
    private String couponCode;

    @Column(name = "description")
    private String description;



    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public PakodiOrders getPakodiOrders() {
        return pakodiOrders;
    }

    public void setPakodiOrders(PakodiOrders pakodiOrders) {
        this.pakodiOrders = pakodiOrders;
    }

    public String getGmailId() {
        return gmailId;
    }

    public void setGmailId(String gmailId) {
        this.gmailId = gmailId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public PakodiOrderStatus getStatus() {
        return status;
    }

    public void setStatus(PakodiOrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getPlacedAt() {
        return placedAt;
    }

    public void setPlacedAt(LocalDateTime placedAt) {
        this.placedAt = placedAt;
    }

    public LocalDateTime getOutForDeliveryAt() {
        return outForDeliveryAt;
    }

    public void setOutForDeliveryAt(LocalDateTime outForDeliveryAt) {
        this.outForDeliveryAt = outForDeliveryAt;
    }

    public LocalDateTime getDeliveredAt() {
        return deliveredAt;
    }

    public void setDeliveredAt(LocalDateTime deliveredAt) {
        this.deliveredAt = deliveredAt;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }





}

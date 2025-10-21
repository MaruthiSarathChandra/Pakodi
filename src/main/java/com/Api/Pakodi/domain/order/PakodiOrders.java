package com.Api.Pakodi.domain.order;


import com.Api.Pakodi.domain.actors.DasherRegistration;
import com.Api.Pakodi.domain.items.Restaurant;
import com.Api.Pakodi.enums.PakodiOrderStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "Pakodi_Orders")
public class PakodiOrders {



    /*
    Section 1: User and Restaurant Details
    * PrimaryKey
    * GmailId : String
    * ResturantId : Class Or Entity
    * Resturant Total : BigDecimal
    * Order Status : Enums


    Section 2: Time
    * PlacedAt : LocalTime
    * DeliveredAt : LocalTime


    Section 3: Dasher
    *  : Entity
    */


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "gmailId", nullable = false)
    private String gmailId;

    @ManyToOne
    @JoinColumn(name = "restaurantId", nullable = false)
    private Restaurant restaurant;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    @Column(name = "orderStatus", nullable = false)
    private PakodiOrderStatus orderStatus;

    @Column(name = "placedAt", nullable = false)
    private LocalDateTime placedAt;

    @Column(name = "deliveredAt", nullable = true)
    private LocalDateTime deliveredAt;


    @ManyToOne
    @JoinColumn(name = "dasherId")
    private DasherRegistration dasherId;




    public Long getId() {
        Long id = Id;
        return id;
    }

    public void setId(Long id) {
        Id = id;
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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public PakodiOrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(PakodiOrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getPlacedAt() {
        return placedAt;
    }

    public void setPlacedAt(LocalDateTime placedAt) {
        this.placedAt = placedAt;
    }

    public LocalDateTime getDeliveredAt() {
        return deliveredAt;
    }

    public void setDeliveredAt(LocalDateTime deliveredAt) {
        this.deliveredAt = deliveredAt;
    }


    public DasherRegistration getDasherId() {
        return dasherId;
    }

    public void setDasherId(DasherRegistration dasherId) {
        this.dasherId = dasherId;
    }

}

package com.Api.Pakodi.domain.order;


import com.Api.Pakodi.domain.items.Restaurant;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PakodiBasket")
public class PakodiBasket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gmailId", nullable = true)
    private String gmailId;


    @Column(name = "sessionId", nullable = false)
    private String sessionId;


    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;


    @Column(name = "expiresAt", nullable = false)
    private LocalDateTime expiresAt;


    @OneToOne
    @JoinColumn(name = "restaurant", nullable = true)
    private Restaurant restaurant;


    @Column(name = "total", nullable = true)
    private BigDecimal total;




    // 1. Getters And Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGmailId() {
        return gmailId;
    }

    public void setGmailId(String gmailId) {
        this.gmailId = gmailId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
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
}

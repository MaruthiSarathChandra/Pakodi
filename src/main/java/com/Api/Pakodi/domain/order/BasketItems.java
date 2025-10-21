package com.Api.Pakodi.domain.order;


import com.Api.Pakodi.domain.items.Menu;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "BasketItems")
public class BasketItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pakodiBasketId", nullable = false)
    private PakodiBasket pakodiBasketId;

    @Column(name = "gmailId")
    private String gmailId;

    @ManyToOne
    @JoinColumn(name = "menuId", nullable = false)
    private Menu menuId;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "couponCode", nullable = true)
    private String couponCode;


    @Column(name = "tax", nullable = false)
    private BigDecimal tax;


    @Column(name = "total", nullable = false)
    private BigDecimal total;




    //1. Getters And Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGmailId() {
        return gmailId;
    }

    public void setGmailId(String gmail) {
        this.gmailId = gmail;
    }

    public PakodiBasket getPakodiBasket() {
        return pakodiBasketId;
    }

    public void setPakodiBasket(PakodiBasket pakodiBasketId) {
        this.pakodiBasketId = pakodiBasketId;
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

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

}

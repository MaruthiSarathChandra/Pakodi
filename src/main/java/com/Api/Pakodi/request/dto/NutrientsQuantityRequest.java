package com.Api.Pakodi.request.dto;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class NutrientsQuantityRequest {

    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setNutrientName(String nutrientName) {
        this.nutrientName = nutrientName;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    private String nutrientName;
    private String units;
    private BigDecimal quantity;



    public int getId() {
        return id;
    }

    public String getNutrientName() {
        return nutrientName;
    }

    public String getUnits() {
        return units;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }


}

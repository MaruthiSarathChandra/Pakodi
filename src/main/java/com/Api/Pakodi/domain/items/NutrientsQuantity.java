package com.Api.Pakodi.domain.items;

import com.Api.Pakodi.domain.items.Menu;
import com.Api.Pakodi.domain.items.Nutrients;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "NutrientsQuantity")
public class NutrientsQuantity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "menuId", nullable = false)
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "nutrientsId", nullable = false)
    private Nutrients nutrients;

    @Column(name = "quantity")
    private BigDecimal quantity;




    //Getter for table NutrientsQuantity
    public int getId() {return id;}

    public Menu getMenu() {return menu;}

    public Nutrients getNutrients() {
        return nutrients;}

    public BigDecimal getQuantity() {return quantity;}
}

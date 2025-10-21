package com.Api.Pakodi.domain.items;

import jakarta.persistence.*;

@Entity
@Table(name = "Nutrients")
public class Nutrients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String unit;



   //Getters for table Nutrients
    public Long getId() {return id;}

    public String getName() {return name;}

    public String getUnit() {return unit;}
}
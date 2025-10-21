package com.Api.Pakodi.domain.items;


import jakarta.persistence.*;

@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "restaurantName", nullable = false)
    private String restaurantName;

    @Column(name = "restaurantAddress", nullable = false)
    private String address;

    @Column(name = "restaurantImage", nullable = false)
    private String image;



    //Getters For Restaurant
    public Long getId() { return id;}
    public String getRestaurantName() {return restaurantName;}
    public String getAddress() {return address;}
    public String getImage() { return image;}
}

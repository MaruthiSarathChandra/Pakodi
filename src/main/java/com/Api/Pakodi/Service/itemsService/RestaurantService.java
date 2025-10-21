package com.Api.Pakodi.Service.itemsService;

import com.Api.Pakodi.Repository.itemsRepo.RestaurantRepo;
import com.Api.Pakodi.domain.items.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class RestaurantService {

    @Autowired
    private RestaurantRepo restaurantRepo;

    public List<Restaurant> getAllRestaurant() {
        return restaurantRepo.findAll();
    }
}

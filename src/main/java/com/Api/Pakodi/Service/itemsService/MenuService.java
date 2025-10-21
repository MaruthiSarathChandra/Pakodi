package com.Api.Pakodi.Service.itemsService;


import com.Api.Pakodi.Repository.itemsRepo.MenuRepo;
import com.Api.Pakodi.Repository.itemsRepo.RestaurantRepo;
import com.Api.Pakodi.domain.items.Menu;
import com.Api.Pakodi.domain.items.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MenuService {

    @Autowired
    private MenuRepo menuRepo;
    @Autowired
    private RestaurantRepo restaurantRepo;

    public List<Menu> getMenuByRestaurantId(Restaurant restaurantId) {

        //Implementing the method which is in MenuRepo here
        return menuRepo.findByRestaurantId(restaurantId);
    }


    public Optional<Menu> getMenuById(Long id) {

        return menuRepo.findById(id);
    }
}

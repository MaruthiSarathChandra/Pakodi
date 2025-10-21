package com.Api.Pakodi.Controller.itemsController;

import com.Api.Pakodi.Service.itemsService.RestaurantService;
import com.Api.Pakodi.domain.items.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/pakodi/api")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public ResponseEntity<List<Restaurant>> getAllRestaurant() {
        return ResponseEntity.ok(restaurantService.getAllRestaurant());
    }
}

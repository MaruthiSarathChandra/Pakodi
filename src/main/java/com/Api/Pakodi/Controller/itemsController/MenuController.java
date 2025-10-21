package com.Api.Pakodi.Controller.itemsController;

import com.Api.Pakodi.Service.itemsService.MenuService;
import com.Api.Pakodi.domain.items.Menu;
import com.Api.Pakodi.domain.items.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/pakodi/api/restaurant")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/{restaurantId}/menus")
    public ResponseEntity<List<Menu>> getMenusByRestaurantId(@PathVariable Restaurant restaurantId) {
        return ResponseEntity.ok(menuService.getMenuByRestaurantId(restaurantId));
    }
}

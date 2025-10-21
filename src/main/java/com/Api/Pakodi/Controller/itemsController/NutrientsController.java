package com.Api.Pakodi.Controller.itemsController;

import com.Api.Pakodi.Service.itemsService.NutrientsService;
import com.Api.Pakodi.domain.items.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pakodi/api/menu")
public class NutrientsController {

    @Autowired
    private NutrientsService nutrientsService;

    @GetMapping("/huha")
    public String getNutrientsByMenu(@PathVariable Menu menuId) {
        return "";
    }
}

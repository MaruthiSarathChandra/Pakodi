package com.Api.Pakodi.Controller.itemsController;


import com.Api.Pakodi.Service.itemsService.NutrientsQuantityService;
import com.Api.Pakodi.request.dto.NutrientsQuantityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/pakodi/api/menu")
public class NutrientsQuantityController {
    @Autowired
    private NutrientsQuantityService nutrientsQuantityService;

    @GetMapping("/{menuId}/nutrients")
    public ResponseEntity<List<NutrientsQuantityRequest>> getNutrientsByMenu(@PathVariable Long menuId){
        List<NutrientsQuantityRequest> response = nutrientsQuantityService.getNutrientsByMenu(menuId);
        return ResponseEntity.ok(response);
    }
}

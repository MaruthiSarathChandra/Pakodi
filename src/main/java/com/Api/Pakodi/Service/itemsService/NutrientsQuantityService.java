package com.Api.Pakodi.Service.itemsService;

import com.Api.Pakodi.Repository.itemsRepo.NutrientsQuantityRepo;
import com.Api.Pakodi.request.dto.NutrientsQuantityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class NutrientsQuantityService {

    @Autowired
    private NutrientsQuantityRepo nutrientsQuantityRepo;



    public List<NutrientsQuantityRequest> getNutrientsByMenu(Long menuId) {


        //Response form repo layer
        List<Object[]> objectArr = nutrientsQuantityRepo.findNutrientsByMenuId(menuId);
        //Array creation
        List<NutrientsQuantityRequest> responseArray = new ArrayList<>();


        for(Object[] i: objectArr) {


            NutrientsQuantityRequest nutrientsQuantityRequest = new NutrientsQuantityRequest();

            //TypeCasting
            int id = (Integer) i[0];
            String nutrientsName = (String) i[1];
            String unit = (String) i[2];
            BigDecimal quantity = (BigDecimal) i[3];


            nutrientsQuantityRequest.setId(id);
            nutrientsQuantityRequest.setNutrientName(nutrientsName);
            nutrientsQuantityRequest.setUnits(unit);
            nutrientsQuantityRequest.setQuantity(quantity);


            responseArray.add(nutrientsQuantityRequest);
        }


        return responseArray;
    }
}

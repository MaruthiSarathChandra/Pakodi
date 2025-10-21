package com.Api.Pakodi.Service.itemsService;

import com.Api.Pakodi.Repository.itemsRepo.NutrientsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NutrientsService {

    @Autowired
    private NutrientsRepo nutrientsRepo;

}

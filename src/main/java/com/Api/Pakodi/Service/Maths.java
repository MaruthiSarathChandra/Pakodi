package com.Api.Pakodi.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class Maths {

    @Value("${spring.pakodi.BigDecimal.tax}")
    private BigDecimal tax;

    public List<BigDecimal> afterTaxBeforeAmount(BigDecimal price, Long quantity){

        List<BigDecimal> response = new ArrayList<>();


        BigDecimal quantityBD = BigDecimal.valueOf(quantity);
        BigDecimal totalTaxValue = price.multiply(quantityBD).multiply(tax).divide(BigDecimal.valueOf(100));
        BigDecimal totalValue = price.multiply(quantityBD).add(totalTaxValue);

        response.add(totalTaxValue);
        response.add(totalValue);


        return response;
    }


}

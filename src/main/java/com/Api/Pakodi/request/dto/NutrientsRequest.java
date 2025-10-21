package com.Api.Pakodi.request.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jdk.jfr.DataAmount;
import org.springframework.stereotype.Component;


@Component
public class NutrientsRequest {

    private Long id;
    private String name;
    private String unit;
}

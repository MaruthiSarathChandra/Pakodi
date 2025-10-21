package com.Api.Pakodi.domain.actors;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "DasherRegistration")
public class DasherRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

}

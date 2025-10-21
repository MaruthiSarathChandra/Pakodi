package com.Api.Pakodi.domain.actors;


import com.Api.Pakodi.domain.actors.DasherRegistration;
import com.Api.Pakodi.domain.order.PakodiOrders;
import com.Api.Pakodi.enums.DasherPaymentStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "DasherWallet")
public class DasherWallet {

    /*
    * Primary Key : Long
    * PakodiOrders : Entity
    * DasherRegistration: Entity
    * Total : BigDecimal
    * Tip : BigDecimal
    * Status : Enums
    * */




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "dasherId",nullable = false)
    private DasherRegistration dasherId;

    @ManyToOne
    @JoinColumn(name = "PakodiOrders", nullable = false)
    private PakodiOrders pakodiOrders;


    @Column(name = "Total")
    private BigDecimal total;

    @Column(name = "Tips")
    private BigDecimal tip;

    @Enumerated(EnumType.STRING)
    @Column(name = "PaymentStatus", nullable = false)
    private DasherPaymentStatus paymentStatus;


}

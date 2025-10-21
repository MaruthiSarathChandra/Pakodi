package com.Api.Pakodi.enums;


public enum DasherPaymentStatus {

    SETTLED,      // Payment is completed
    UNSETTLED,    // Payment is due
    PROCESSING,   // Payment is being processed
    PENDING,      // Waiting for approval or processing
    FAILED,       // Payment attempt failed
    ON_HOLD       // Payment temporarily withheld

}

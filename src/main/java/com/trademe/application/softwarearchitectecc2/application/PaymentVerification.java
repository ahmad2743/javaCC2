package com.trademe.application.softwarearchitectecc2.application;

import com.trademe.application.softwarearchitectecc2.domain.model.CreditCard;
import com.trademe.application.softwarearchitectecc2.kernel.PaymentVerificationEngine;
import org.springframework.stereotype.Component;

@Component
public class PaymentVerification implements PaymentVerificationEngine {

    public static void PaymentRequest(CreditCard card) {
        System.out.println("making request for payment ");
        if (card.isValid())
            System.out.println("successful payment");
        else
            System.out.println("credit card not valid");
    }
}

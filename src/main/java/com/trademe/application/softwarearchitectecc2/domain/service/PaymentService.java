package com.trademe.application.softwarearchitectecc2.domain.service;

import com.trademe.application.softwarearchitectecc2.domain.model.CreditCard;

public class PaymentService {
    public static void makePayment(CreditCard card){
        if (card.isValid())
            System.out.println("successful payment");
        else
            System.out.println("cedit card not valid");
        return;
    }
}

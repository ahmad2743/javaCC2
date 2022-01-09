package com.trademe.application.softwarearchitectecc2.domain.model;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class CreditCard {
    private final String ownerCardName;
    private final String cardNumber;
    private final String validityDate;
    private final int cvvCode;

    public CreditCard(String ownerCardName, String cardNumber, String validityDate, int cvvCode) {
        this.ownerCardName = ownerCardName;
        this.cardNumber = cardNumber;
        this.validityDate = validityDate;
        this.cvvCode = cvvCode;
    }
    public static CreditCard createCreditCardCredential(String ownerCardName, String cardNumber, String validityDate, int cvvCode){
        return new CreditCard(ownerCardName, cardNumber, validityDate, cvvCode);
    }

    public boolean isValid(){
       if(cardNumber.length() == 16){
            if(cvvCode == 3){
                String[] parts = validityDate.split("/");
                int cardYear = Integer.valueOf(parts[1]);
                Date currentDate = new Date();
                int currentYear = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(currentDate)).getYear();
                if(currentYear <= cardYear){
                    return true;
                }
                else
                    return false;
            }
            return false;
       }
       return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return cvvCode == that.cvvCode && ownerCardName.equals(that.ownerCardName) && cardNumber.equals(that.cardNumber) && validityDate.equals(that.validityDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerCardName, cardNumber, validityDate, cvvCode);
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "ownerCardName='" + ownerCardName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", validityDate='" + validityDate + '\'' +
                '}';
    }
}

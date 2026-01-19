package com.numa.hotel.valueobject;

public class CreditCard {
    
      private final String number;

    public CreditCard(String number) {
        if (number == null || number.length() < 12) {
            throw new IllegalArgumentException("Invalid credit card number");
        }
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}

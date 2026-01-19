package com.numa.hotel.domain;

import com.numa.hotel.valueobject.Money;

public class ReserverPayer {

    private final Guest guest;
    private final Money paymentAmount;

    public ReserverPayer(Guest guest, Money paymentAmount) {
        if (guest == null) {
            throw new IllegalArgumentException("Guest must not be null");
        }
        if (paymentAmount == null) {
            throw new IllegalArgumentException("Payment amount must not be null");
        }

        this.guest = guest;
        this.paymentAmount = paymentAmount;
    }

    public Guest getGuest() {
        return guest;
    }

    public Money getPaymentAmount() {
        return paymentAmount;
    }
}

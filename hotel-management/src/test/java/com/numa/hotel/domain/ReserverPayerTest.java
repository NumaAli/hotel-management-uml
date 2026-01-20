package com.numa.hotel.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.numa.hotel.valueobject.Address;
import com.numa.hotel.valueobject.Money;
import com.numa.hotel.valueobject.Name;

class ReserverPayerTest {

    @Test
    @DisplayName("Should create ReserverPayer with guest and payment")
    void shouldCreatePayer() {
        Guest guest = new Guest(new Name("Alice"), new Address("Street 1"));
        Money payment = new Money(500.0);

        ReserverPayer payer = new ReserverPayer(guest, payment);

        assertNotNull(payer);
        assertEquals(guest, payer.getGuest());
        assertEquals(payment, payer.getPaymentAmount());
    }

    @Test
    @DisplayName("Should reject null guest")
    void shouldRejectNullGuest() {
        Money payment = new Money(500.0);
        assertThrows(IllegalArgumentException.class, () -> new ReserverPayer(null, payment));
    }

    @Test
    @DisplayName("Should reject null payment")
    void shouldRejectNullPayment() {
        Guest guest = new Guest(new Name("Alice"), new Address("Street 1"));
        assertThrows(IllegalArgumentException.class, () -> new ReserverPayer(guest, null));
    }
}

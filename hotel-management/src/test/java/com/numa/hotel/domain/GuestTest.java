package com.numa.hotel.domain;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.numa.hotel.valueobject.Address;
import com.numa.hotel.valueobject.Name;

class GuestTest {

    @Test
    @DisplayName("Should create Guest with valid name and address")
    void shouldCreateGuestWithValidInputs() {
        Name name = new Name("Alice");
        Address address = new Address("Main Street");

        Guest guest = new Guest(name, address);

        assertNotNull(guest);
        assertEquals(name, guest.getName());
        assertEquals(address, guest.getAddress());
    }

    @Test
    @DisplayName("Should reject null name")
    void shouldRejectNullName() {
        Address address = new Address("Main Street");

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Guest(null, address)
        );

        assertTrue(exception.getMessage().toLowerCase().contains("name"));
    }

    @Test
    @DisplayName("Should reject null address")
    void shouldRejectNullAddress() {
        Name name = new Name("Alice");

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Guest(name, null)
        );

        assertTrue(exception.getMessage().toLowerCase().contains("address"));
    }
}

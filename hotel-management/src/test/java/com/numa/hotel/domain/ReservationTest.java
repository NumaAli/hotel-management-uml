package com.numa.hotel.domain;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.numa.hotel.enumtype.RoomKind;
import com.numa.hotel.valueobject.Address;
import com.numa.hotel.valueobject.Money;
import com.numa.hotel.valueobject.Name;

class ReservationTest {

    @Test
    @DisplayName("Should create Reservation with valid guest, room, and dates")
    void shouldCreateReservation() {
        Guest guest = new Guest(new Name("Alice"), new Address("Street 1"));
        RoomType roomType = new RoomType(RoomKind.SUITE, new Money(250.0));
        Room room = new Room(101, roomType);

        LocalDate checkIn = LocalDate.of(2026, 1, 1);
        LocalDate checkOut = LocalDate.of(2026, 1, 5);

        Reservation res = new Reservation(guest, room, checkIn, checkOut);

        assertNotNull(res);
        assertEquals(guest, res.getGuest());
        assertEquals(room, res.getRoom());
        assertEquals(checkIn, res.getCheckInDate());
        assertEquals(checkOut, res.getCheckOutDate());
    }

    @Test
    @DisplayName("Should reject null guest")
    void shouldRejectNullGuest() {
        RoomType roomType = new RoomType(RoomKind.SUITE, new Money(250.0));
        Room room = new Room(101, roomType);
        LocalDate checkIn = LocalDate.of(2026, 1, 1);
        LocalDate checkOut = LocalDate.of(2026, 1, 5);

        assertThrows(IllegalArgumentException.class,
                () -> new Reservation(null, room, checkIn, checkOut));
    }

    @Test
    @DisplayName("Should reject invalid date range")
    void shouldRejectInvalidDateRange() {
        Guest guest = new Guest(new Name("Alice"), new Address("Street 1"));
        RoomType roomType = new RoomType(RoomKind.SUITE, new Money(250.0));
        Room room = new Room(101, roomType);

        LocalDate checkIn = LocalDate.of(2026, 1, 5);
        LocalDate checkOut = LocalDate.of(2026, 1, 1);

        assertThrows(IllegalArgumentException.class,
                () -> new Reservation(guest, room, checkIn, checkOut));
    }
}

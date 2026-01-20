package com.numa.hotel.domain;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.numa.hotel.enumtype.RoomKind;
import com.numa.hotel.valueobject.Address;
import com.numa.hotel.valueobject.Money;
import com.numa.hotel.valueobject.Name;

class HotelTest {

    @Test
    @DisplayName("Should add room and reservation")
    void shouldAddRoomAndReservation() {
        Hotel hotel = new Hotel("Grand Hotel");

        RoomType roomType = new RoomType(RoomKind.SUITE, new Money(250.0));
        Room room = new Room(101, roomType);
        hotel.addRoom(room);

        Guest guest = new Guest(new Name("Alice"), new Address("Street 1"));
        Reservation res = new Reservation(guest, room, LocalDate.of(2026, 1, 1), LocalDate.of(2026, 1, 5));
        hotel.addReservation(res);

        assertTrue(hotel.getRooms().contains(room));
        assertTrue(hotel.getReservations().contains(res));
    }

    @Test
    @DisplayName("Should reject null room or reservation")
    void shouldRejectNull() {
        Hotel hotel = new Hotel("Grand Hotel");
        assertThrows(IllegalArgumentException.class, () -> hotel.addRoom(null));
        assertThrows(IllegalArgumentException.class, () -> hotel.addReservation(null));
    }
}

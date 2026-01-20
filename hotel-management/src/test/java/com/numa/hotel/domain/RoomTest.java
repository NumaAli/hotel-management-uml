package com.numa.hotel.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.numa.hotel.enumtype.RoomKind;

class RoomTest {

    @Test
    @DisplayName("Should create Room with valid number and RoomType")
    void shouldCreateRoom() {
        RoomType deluxe = new RoomType(RoomKind.SUITE, new com.numa.hotel.valueobject.Money(250.0));
        Room room = new Room(101, deluxe);

        assertNotNull(room);
        assertEquals(101, room.getRoomNumber());
        assertEquals(deluxe, room.getRoomType());
    }

    @Test
    @DisplayName("Should reject invalid room number")
    void shouldRejectInvalidRoomNumber() {
        RoomType deluxe = new RoomType(RoomKind.SUITE, new com.numa.hotel.valueobject.Money(250.0));

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Room(0, deluxe)
        );
        assertTrue(exception.getMessage().toLowerCase().contains("number"));
    }

    @Test
    @DisplayName("Should reject null RoomType")
    void shouldRejectNullRoomType() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Room(101, null)
        );
        assertTrue(exception.getMessage().toLowerCase().contains("roomtype"));
    }
}

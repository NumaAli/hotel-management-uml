package com.numa.hotel.domain;
import java.time.LocalDate;
public class Reservation {

    private final Guest guest;
    private final Room room;
    private final LocalDate checkInDate;
    private final LocalDate checkOutDate;

    public Reservation(Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        if (guest == null) {
            throw new IllegalArgumentException("Guest must not be null");
        }
        if (room == null) {
            throw new IllegalArgumentException("Room must not be null");
        }
        if (checkInDate == null || checkOutDate == null) {
            throw new IllegalArgumentException("Dates must not be null");
        }
        if (!checkOutDate.isAfter(checkInDate)) {
            throw new IllegalArgumentException("Check-out date must be after check-in date");
        }

        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }
}

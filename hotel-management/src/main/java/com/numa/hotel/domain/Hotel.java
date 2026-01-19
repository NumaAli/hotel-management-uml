package com.numa.hotel.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hotel {

    private final String name;
    private final List<Room> rooms = new ArrayList<>();
    private final List<Reservation> reservations = new ArrayList<>();

    public Hotel(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Hotel name must not be empty");
        }
        this.name = name;
    }

    public void addRoom(Room room) {
        if (room == null) {
            throw new IllegalArgumentException("Room must not be null");
        }
        rooms.add(room);
    }

    public void addReservation(Reservation reservation) {
        if (reservation == null) {
            throw new IllegalArgumentException("Reservation must not be null");
        }
        reservations.add(reservation);
    }

    public String getName() {
        return name;
    }

    public List<Room> getRooms() {
        return Collections.unmodifiableList(rooms);
    }

    public List<Reservation> getReservations() {
        return Collections.unmodifiableList(reservations);
    }
}

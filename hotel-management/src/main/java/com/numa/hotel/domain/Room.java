package com.numa.hotel.domain;

public class Room {

    private final int roomNumber;
    private final RoomType roomType;

    public Room(int roomNumber, RoomType roomType) {
        if (roomNumber <= 0) {
            throw new IllegalArgumentException("Room number must be positive");
        }
        if (roomType == null) {
            throw new IllegalArgumentException("RoomType must not be null");
        }

        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }
}

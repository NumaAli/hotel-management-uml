package com.numa.hotel.valueobject;

public class HowMany {

    private final int number;

    public HowMany(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number must be greater than zero");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

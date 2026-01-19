package com.numa.hotel.valueobject;

public final class Name {
    private final String value;

    public Name(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

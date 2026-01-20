package com.numa.hotel.domain;

import com.numa.hotel.valueobject.Address;
import com.numa.hotel.valueobject.Name;

public class Guest {

    private final Name name;
    private final Address address;

    public Guest(Name name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Must have these getters
    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}

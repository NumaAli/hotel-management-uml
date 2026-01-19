package com.numa.hotel.domain;

import com.numa.hotel.valueobject.Address;
import com.numa.hotel.valueobject.Name;

public class Guest {

    private final Name name;
    private final Address addressDetails;

    public Guest(Name name, Address addressDetails) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (addressDetails == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }

        this.name = name;
        this.addressDetails = addressDetails;
    }

    public static Guest create(Name name, Address address) {
        return new Guest(name, address);
    }
}

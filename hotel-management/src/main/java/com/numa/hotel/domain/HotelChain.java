package com.numa.hotel.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotelChain {

    private final String chainName;
    private final List<Hotel> hotels = new ArrayList<>();

    public HotelChain(String chainName) {
        if (chainName == null || chainName.isBlank()) {
            throw new IllegalArgumentException("Hotel chain name must not be empty");
        }
        this.chainName = chainName;
    }

    public void addHotel(Hotel hotel) {
        if (hotel == null) {
            throw new IllegalArgumentException("Hotel must not be null");
        }
        hotels.add(hotel);
    }

    public String getChainName() {
        return chainName;
    }

    public List<Hotel> getHotels() {
        return Collections.unmodifiableList(hotels);
    }
}

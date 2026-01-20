package com.numa.hotel.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HotelChainTest {

    @Test
    @DisplayName("Should add hotel to hotel chain")
    void shouldAddHotel() {
        HotelChain chain = new HotelChain("Luxury Hotels Inc.");
        Hotel hotel = new Hotel("Grand Hotel");
        chain.addHotel(hotel);

        assertTrue(chain.getHotels().contains(hotel));
        assertEquals("Luxury Hotels Inc.", chain.getChainName());
    }

    @Test
    @DisplayName("Should reject null hotel")
    void shouldRejectNullHotel() {
        HotelChain chain = new HotelChain("Luxury Hotels Inc.");
        assertThrows(IllegalArgumentException.class, () -> chain.addHotel(null));
    }
}

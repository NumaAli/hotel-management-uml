package com.numa.hotel.valueobject;

import java.util.UUID;

public class Identity {
    
   private final String id;

    public Identity() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }
}

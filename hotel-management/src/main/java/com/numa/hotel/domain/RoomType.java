package com.numa.hotel.domain;
import com.numa.hotel.enumtype.RoomKind;
import com.numa.hotel.valueobject.Money;



public class RoomType {

    private final RoomKind kind;
    private final Money cost;

    public RoomType(RoomKind kind, Money cost) {
        if (kind == null) {
            throw new IllegalArgumentException("Room kind cannot be null");
        }
        if (cost == null) {
            throw new IllegalArgumentException("Cost cannot be null");
        }

        this.kind = kind;
        this.cost = cost;
    }

    public RoomKind getKind() {
        return kind;
    }

    public Money getCost() {
        return cost;
    }
}
package com.numa.hotel;

import java.time.LocalDate;

import com.numa.hotel.domain.Guest;
import com.numa.hotel.domain.Hotel;
import com.numa.hotel.domain.HotelChain;
import com.numa.hotel.domain.Reservation;
import com.numa.hotel.domain.ReserverPayer;
import com.numa.hotel.domain.Room;
import com.numa.hotel.domain.RoomType;
import com.numa.hotel.enumtype.RoomKind;
import com.numa.hotel.valueobject.Address;
import com.numa.hotel.valueobject.Money;
import com.numa.hotel.valueobject.Name;

public class Main {

    public static void main(String[] args) {

        // ARRANGE: Value Objects
        Name guestName = new Name("Alice Smith");
        Address guestAddress = new Address("456 Elm Street, Metropolis, CountryX");
        Money payment = new Money(500.0);

        // ARRANGE: Guest
        Guest guest = new Guest(guestName, guestAddress);

        // ARRANGE: Hotel Structure
        Hotel hotel = new Hotel("Grand Hotel");

        RoomType deluxeRoomType = new RoomType(
                RoomKind.SUITE,
                new Money(250.0)
        );
        Room room1 = new Room(101, deluxeRoomType);
        hotel.addRoom(room1);

        // ARRANGE: Reservation
        Reservation reservation = new Reservation(
                guest,
                room1,
                LocalDate.of(2026, 2, 1),
                LocalDate.of(2026, 2, 5)
        );

        hotel.addReservation(reservation);

        // ARRANGE: Payment Role
        ReserverPayer payer = new ReserverPayer(guest, payment);

        HotelChain chain = new HotelChain("Luxury Hotels Inc.");
        chain.addHotel(hotel);
        System.out.println("=== Hotel Chain Info ===");
        System.out.println("Chain Name: " + chain.getChainName());

        for (Hotel h : chain.getHotels()) {
            System.out.println("\nHotel: " + h.getName());

            System.out.println("Rooms:");
            for (Room r : h.getRooms()) {
                System.out.println(
                        " - Room #" + r.getRoomNumber()
                        + " | Type: " + r.getRoomType().getKind()
                        + " | Cost: $" + r.getRoomType().getCost().getAmount()
                );
            }

            System.out.println("Reservations:");
            for (Reservation res : h.getReservations()) {
                System.out.println(" - Guest: " + res.getGuest().getName().getValue());
                System.out.println("   Address: " + res.getGuest().getAddress().getValue());
                System.out.println("   Room: " + res.getRoom().getRoomNumber());
                System.out.println("   Check-in: " + res.getCheckInDate());
                System.out.println("   Check-out: " + res.getCheckOutDate());
            }
        }

        System.out.println("\nPayment Info:");
        System.out.println("Guest: " + payer.getGuest().getName().getValue());
        System.out.println("Amount: $" + payer.getPaymentAmount().getAmount());
    }
}

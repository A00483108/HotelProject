package com.smu.mscda.hotelproject.controller;

import com.smu.mscda.hotelproject.*;
import com.smu.mscda.hotelproject.dto.*;
import com.smu.mscda.hotelproject.repository.HotelRepository;
import com.smu.mscda.hotelproject.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private HotelRepository hotelRepository;
    @GetMapping("/confirmation/{confirmationNumber}")
    public Reservation getReservationByConfirmationId(@PathVariable String confirmationNumber) {
        return reservationRepository.findByConfirmationNumber(confirmationNumber);
    }
    @PostMapping
    public Map<String, String> createReservation(@RequestBody ReservationRequest request) {

        // Find the hotel by name
        Optional<Hotel> optionalHotel = hotelRepository.findById(request.getHotelId());
        if (optionalHotel.isEmpty()) {
            throw new RuntimeException("Hotel not found: " + request.getHotelId());
        }

        Hotel hotel = optionalHotel.get();

        // Generate confirmation number
        String year = String.valueOf(LocalDate.now().getYear());
        long count = reservationRepository.countByYear(year);
        String confirmationNumber = "R-" + year + "-" + String.format("%04d", count + 1);

        // Create Reservation
        Reservation reservation = new Reservation();
        reservation.setConfirmationNumber(confirmationNumber);
        reservation.setCheckin(Date.from(request.getCheckin().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        reservation.setCheckout(Date.from(request.getCheckout().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        reservation.setHotel(hotel);

        // Create Guests
        List<Guest> guests = new ArrayList<>();
        for (GuestRequest guestRequest : request.getGuestsList()) {
            Guest guest = new Guest();
            guest.setGuestName(guestRequest.getGuestName());
            guest.setGender(guestRequest.getGender());
            guest.setReservation(reservation); // link guest to reservation
            guests.add(guest);
        }
        reservation.setGuests(guests);

        // Save reservation and cascade guests
        reservationRepository.save(reservation);

        // Response
        Map<String, String> response = new HashMap<>();
        response.put("confirmation_number", confirmationNumber);
        return response;
    }
}

package com.smu.mscda.hotelproject.service;

import com.smu.mscda.hotelproject.Reservation;
import com.smu.mscda.hotelproject.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public String generateConfirmationNumber() {
        String year = String.valueOf(LocalDate.now().getYear());
        String prefix = "R-" + year + "-";

        // Count how many reservations exist for this year
        long count = reservationRepository.countByYear(year);

        // Add 1 to count and format as 4-digit number
        String number = String.format("%04d", count + 1);

        return prefix + number;
    }

    public Reservation createReservation(Reservation reservation) {
        reservation.setConfirmationNumber(generateConfirmationNumber());
        return reservationRepository.save(reservation);
    }
}


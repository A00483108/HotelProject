package com.smu.mscda.hotelproject.repository;

import com.smu.mscda.hotelproject.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    // Custom method to count reservations by year (for confirmation number generation)
    @Query("SELECT COUNT(r) FROM Reservation r WHERE FUNCTION('YEAR', r.checkin) = :year")
    long countByYear(@Param("year") String year);

    // Optional: find by confirmation number
    Reservation findByConfirmationNumber(String confirmationNumber);
}

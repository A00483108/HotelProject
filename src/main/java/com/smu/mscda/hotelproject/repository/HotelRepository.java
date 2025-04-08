package com.smu.mscda.hotelproject.repository;

import com.smu.mscda.hotelproject.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    // Custom query methods (if needed)
    List<Hotel> findByLocation(String location);
}

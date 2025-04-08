package com.smu.mscda.hotelproject.dto;

import java.time.LocalDate;
import java.util.List;

public class ReservationRequest {
    private Long hotelId;
    private LocalDate checkin;
    private LocalDate checkout;
    private List<GuestRequest> guestsList;

    // Getters and Setters
    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }
    public LocalDate getCheckin() {
        return checkin;
    }
    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }
    public LocalDate getCheckout() {
        return checkout;
    }
    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }
    public List<GuestRequest> getGuestsList() {
        return guestsList;
    }
    public void setGuestsList(List<GuestRequest> guestsList) {
        this.guestsList = guestsList;
    }
}

package com.smu.mscda.hotelproject;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long reservationId; // ✅ Primary key

    @Column(name = "confirmation_number", nullable = false, unique = true)
    private String confirmationNumber;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date checkin;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date checkout;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private List<Guest> guests;

    // Constructors
    public Reservation() {}

    public Reservation(String confirmationNumber, Date checkin, Date checkout, Hotel hotel, List<Guest> guests) {
        this.confirmationNumber = confirmationNumber;
        this.checkin = checkin;
        this.checkout = checkout;
        this.hotel = hotel;
        this.guests = guests;
    }

    // Getters and Setters
    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }
}

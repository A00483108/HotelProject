package com.smu.mscda.hotelproject;

import jakarta.persistence.*;

@Entity
@Table(name = "guest")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guest_id")
    private Long id;

    @Column(name = "guest_name", nullable = false)
    private String guestName;

    @Column(nullable = false)
    private String gender;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    // Constructors
    public Guest() {}

    public Guest(String guestName, String gender, Reservation reservation) {
        this.guestName = guestName;
        this.gender = gender;
        this.reservation = reservation;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}

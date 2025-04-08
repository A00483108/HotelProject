package com.smu.mscda.hotelproject;

import jakarta.persistence.*;


@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Long id;

    @Column(name = "hotel_name", nullable = false, unique = true)
    private String hotelName;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private boolean availability;

    // Constructors
    public Hotel() {}

    public Hotel(String hotelName, String location, Integer price, boolean availability) {
        this.hotelName = hotelName;
        this.location = location;
        this.price = price;
        this.availability = availability;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
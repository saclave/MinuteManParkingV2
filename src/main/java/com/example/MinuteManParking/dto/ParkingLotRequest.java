package com.example.MinuteManParking.dto;

public class ParkingLotRequest {
    private Double longitude;
    private Double latitude;
    private String address;
    private Double price;

    public ParkingLotRequest() {

    }

    public ParkingLotRequest(Double longitude, Double latitude, String address, Double price) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.price = price;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

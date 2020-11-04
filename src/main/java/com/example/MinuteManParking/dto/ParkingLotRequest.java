package com.example.MinuteManParking.dto;

public class ParkingLotRequest {
    private Double longitude;
    private Double latitude;
    private String address;
    private Double price;
    private String name;
    private String img_src;

    public ParkingLotRequest() {

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgSrc() { return img_src; }

    public void setImgSrc(String img_src) { this.img_src = img_src; }

}

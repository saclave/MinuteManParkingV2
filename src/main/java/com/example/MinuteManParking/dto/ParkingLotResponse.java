package com.example.MinuteManParking.dto;

import com.example.MinuteManParking.model.ParkingSlot;

import java.util.List;

public class ParkingLotResponse {
    private Integer id;
    private Double longitude;
    private Double latitude;
    private String address;
    private Double price;
    private String name;
    private Integer available;
    private Integer capacity;
    private List<ParkingSlot> parkingSlotList;
    private String img_src;
    private String city;

    public ParkingLotResponse() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<ParkingSlot> getParkingSlotList() {
        return parkingSlotList;
    }

    public void setParkingSlotList(List<ParkingSlot> parkingSlotList) {
        this.parkingSlotList = parkingSlotList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getImgSrc() { return img_src; }

    public void setImgSrc(String img_src) { this.img_src = img_src; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }
}

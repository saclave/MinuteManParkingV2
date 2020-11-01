package com.example.MinuteManParking.dto;

public class CarResponse {
    Integer carId;
    Integer userId;
    String plateNumber;
    String color;
    String brand;

    public CarResponse() { }

    public CarResponse(String plateNumber, String color, String brand) {
        this.plateNumber = plateNumber;
        this.color = color;
        this.brand = brand;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}

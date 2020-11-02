package com.example.MinuteManParking.dto;

public class CarRequest {
    private String plateNumber;
    private String color;
    private String brand;

    public CarRequest() { }

    public CarRequest(String plateNumber, String color, String brand) {
        this.plateNumber = plateNumber;
        this.color = color;
        this.brand = brand;
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

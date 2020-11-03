package com.example.MinuteManParking.dto;

import com.example.MinuteManParking.model.Car;

import java.util.List;

public class CarRequest {
    private Integer userId;
    private String plateNumber;
    private String color;
    private String brand;

    public CarRequest() {
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}

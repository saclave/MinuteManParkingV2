package com.example.MinuteManParking.dto;

public class ParkingSlotRequest {
    private Boolean availability;
    private Integer parkingLotId;
    private String name;

    public ParkingSlotRequest() {

    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Integer getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Integer parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.example.MinuteManParking.dto;

public class ParkingSlotResponse {
    Integer id;
    Boolean availability;
    Integer parkingLotId;

    public ParkingSlotResponse(){

    }

    public ParkingSlotResponse(Integer id, Boolean availability, Integer parkingLotId) {
        this.id = id;
        this.availability = availability;
        this.parkingLotId = parkingLotId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}

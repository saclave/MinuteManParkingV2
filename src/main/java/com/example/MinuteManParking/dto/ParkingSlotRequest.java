package com.example.MinuteManParking.dto;

public class ParkingSlotRequest {
    Boolean availability;
    Integer parkingLotId;

    public ParkingSlotRequest(){

    }

    public ParkingSlotRequest(Boolean availability, Integer parkingLotId) {
        this.availability = availability;
        this.parkingLotId = parkingLotId;
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

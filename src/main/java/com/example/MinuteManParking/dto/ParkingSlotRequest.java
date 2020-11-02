package com.example.MinuteManParking.dto;

public class ParkingSlotRequest {
    private Boolean availability;
    private Integer parkingLotId;
    private String parkingSlotName;

    public ParkingSlotRequest() {

    }

    public ParkingSlotRequest(Boolean availability, Integer parkingLotId, String parkingSlotName) {
        this.availability = availability;
        this.parkingLotId = parkingLotId;
        this.parkingSlotName = parkingSlotName;
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

    public String getParkingSlotName() {
        return parkingSlotName;
    }

    public void setParkingSlotName(String parkingSlotName) {
        this.parkingSlotName = parkingSlotName;
    }
}

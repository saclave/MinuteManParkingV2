package com.example.MinuteManParking.dto;

public class ParkingSlotResponse {
    private Integer id;
    private Boolean availability;
    private Integer parkingLotId;
    private String parkingSlotName;

    public ParkingSlotResponse() {

    }

    public ParkingSlotResponse(Integer id, Boolean availability, Integer parkingLotId, String parkingSlotName) {
        this.id = id;
        this.availability = availability;
        this.parkingLotId = parkingLotId;
        this.parkingSlotName = parkingSlotName;
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

    public String getParkingSlotName() {
        return parkingSlotName;
    }

    public void setParkingSlotName(String parkingSlotName) {
        this.parkingSlotName = parkingSlotName;
    }
}

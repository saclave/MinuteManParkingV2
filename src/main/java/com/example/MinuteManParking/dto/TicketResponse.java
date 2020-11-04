package com.example.MinuteManParking.dto;

public class TicketResponse {
    private Integer id;
    private Integer parkingSlotId;
    private Integer carId;
    private String timeIn;
    private String timeOut;
    private String name;
    private Double amount;
    private String parkingLotName;

    public TicketResponse() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParkingSlotId() {
        return parkingSlotId;
    }

    public void setParkingSlotId(Integer parkingSlotId) {
        this.parkingSlotId = parkingSlotId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }
}

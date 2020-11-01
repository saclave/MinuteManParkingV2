package com.example.MinuteManParking.model;

public class Ticket {
    Integer id;
    Integer slotId;
    Integer carId;
    String timeIn;
    String timeOut;

    public Ticket() {

    }

    public Ticket(Integer slotId, Integer carId, String timeIn, String timeOut) {
        this.slotId = slotId;
        this.carId = carId;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSlotId() {
        return slotId;
    }

    public void setSlotId(Integer slotId) {
        this.slotId = slotId;
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
}

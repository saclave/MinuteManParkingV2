package com.example.MinuteManParking.dto;

public class TicketResponse {
    private Integer ticketId;
    private Integer slotId;
    private Integer carId;
    private String timeIn;
    private String timeOut;
    private String ticketName;

    public TicketResponse() {

    }

    public TicketResponse(Integer ticketId, Integer slotId, Integer carId, String timeIn, String timeOut, String ticketName) {
        this.ticketId = ticketId;
        this.slotId = slotId;
        this.carId = carId;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.ticketName = ticketName;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
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

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }
}

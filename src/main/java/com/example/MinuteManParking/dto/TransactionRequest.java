package com.example.MinuteManParking.dto;

public class TransactionRequest {
    private Integer userId;
    private Integer ticketId;

    public TransactionRequest() { }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }
}

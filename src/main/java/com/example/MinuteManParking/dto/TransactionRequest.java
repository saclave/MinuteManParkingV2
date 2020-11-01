package com.example.MinuteManParking.dto;

public class TransactionRequest {
    Integer userId;
    Integer ticketId;

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

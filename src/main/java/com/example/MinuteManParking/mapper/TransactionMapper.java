package com.example.MinuteManParking.mapper;

import com.example.MinuteManParking.dto.TransactionRequest;
import com.example.MinuteManParking.dto.TransactionResponse;
import com.example.MinuteManParking.model.Transaction;
import org.springframework.beans.BeanUtils;

public class TransactionMapper {

    public Transaction toEntity(TransactionRequest transactionRequest) {
        Transaction transaction = new Transaction();
        BeanUtils.copyProperties(transactionRequest, transaction);
        return transaction;
    }

    public TransactionResponse toResponse(Transaction transaction) {
        TransactionResponse transactionResponse = new TransactionResponse();
        BeanUtils.copyProperties(transaction, transactionResponse);
        return transactionResponse;
    }

}

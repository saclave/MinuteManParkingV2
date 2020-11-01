package com.example.MinuteManParking.service;

import com.example.MinuteManParking.advice.TransactionNotFoundException;
import com.example.MinuteManParking.dto.TransactionResponse;
import com.example.MinuteManParking.model.Transaction;
import com.example.MinuteManParking.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.example.MinuteManParking.advice.TransactionNotFoundException.*;

public class TransactionService {
    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction create(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction getTransaction(Integer id) {
        return transactionRepository.findById(id).orElseThrow(() -> new
                TransactionNotFoundException(TRANSACTION_NOT_FOUND));
    }


    public List<Transaction> getAllTransactionsByUser(Integer userId) {
        if(userId == null){
            throw new TransactionNotFoundException(USER_NOT_FOUND);
        }

        return transactionRepository.findByUserId(userId);
    }

    public TransactionResponse getTransactionByTicket(Integer ticketId) {
        if(ticketId == null){
            throw new TransactionNotFoundException(TICKET_NOT_FOUND);
        }
        return transactionRepository.findByTicket(ticketId);
    }

    public void deleteTransaction(Integer id) {
        transactionRepository.deleteById(id);
    }
}

package com.example.MinuteManParking.repository;

import com.example.MinuteManParking.dto.TransactionResponse;
import com.example.MinuteManParking.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByUserId(Integer userId);

    TransactionResponse findByTicket(Integer ticketId);
}

package com.example.MinuteManParking.controller;

import com.example.MinuteManParking.dto.TransactionRequest;
import com.example.MinuteManParking.dto.TransactionResponse;
import com.example.MinuteManParking.mapper.TransactionMapper;
import com.example.MinuteManParking.model.Transaction;
import com.example.MinuteManParking.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;
    private final TransactionMapper transactionMapper;

    public TransactionController(TransactionService transactionService, TransactionMapper transactionMapper) {
        this.transactionService = transactionService;
        this.transactionMapper = transactionMapper;
    }

    @GetMapping
    public List<Transaction> getAll(){ return transactionService.getAllTransactions(); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionResponse addTodo(@RequestBody TransactionRequest transactionRequest){
        Transaction transaction = transactionMapper.toEntity(transactionRequest);
        return transactionMapper.toResponse(transactionService.create(transaction));
    }

    @GetMapping("/{transaction_id}")
    public TransactionResponse getTodo(@PathVariable("id") Integer id) {
        return transactionMapper.toResponse(transactionService.getTransaction(id));
    }

    @GetMapping(params = "{user_id}")
    public List<TransactionResponse> getAllTransactionsByUser(Integer userId) {
        return transactionService.getAllTransactionsByUser(userId).stream()
                .map(transactionMapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping(params = "{ticket_id}")
    public Transaction getTransactionByTicket(Integer ticketId) {
        return transactionService.getTransactionByTicket(ticketId);
    }

    @DeleteMapping("/{transaction_id}")
    public void deleteCompany(@PathVariable Integer id) {
        transactionService.deleteTransaction(id);
    }

}

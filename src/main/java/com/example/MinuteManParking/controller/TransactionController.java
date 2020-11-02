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

import static com.example.MinuteManParking.mapper.TransactionMapper.TRANSACTION_MAPPER;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getAll(){ return transactionService.getAllTransactions(); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionResponse addTodo(@RequestBody TransactionRequest transactionRequest){
        Transaction transaction = TRANSACTION_MAPPER.toEntity(transactionRequest);
        return TRANSACTION_MAPPER.toResponse(transactionService.create(transaction));
    }

    @GetMapping("/{transaction_id}")
    public TransactionResponse getTodo(@PathVariable("id") Integer id) {
        return TRANSACTION_MAPPER.toResponse(transactionService.getTransaction(id));
    }

    @GetMapping(params = "{user_id}")
    public List<TransactionResponse> getAllTransactionsByUser(Integer userId) {
        return transactionService.getAllTransactionsByUser(userId).stream()
                .map(TRANSACTION_MAPPER::toResponse)
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

package com.example.MinuteManParking.service;

import com.example.MinuteManParking.model.Transaction;
import com.example.MinuteManParking.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

public class TransactionServiceTest {
    private TransactionRepository transactionRepository;
    private TransactionService transactionService;

    @BeforeEach
    void setup(){
        transactionRepository = mock(TransactionRepository.class);
        transactionService = new TransactionService(transactionRepository);
    }

    @Test
    void should_return_list_of_todos_when_get_all_todos_given_get_request() {
        //given
        //when
        when(transactionRepository.findAll()).thenReturn(asList(new Transaction(), new Transaction()));
        List<Transaction> transactionRequest = transactionService.getAllTransactions();
        //then
        assertEquals(2, transactionRequest.size());
    }

    @Test
    void should_return_created_todo_when_given_a_todo_request() {
        //given
        //when
        Transaction transactionRequest = new Transaction();
        when(transactionRepository.save(transactionRequest)).thenReturn(transactionRequest);
        Transaction actual = transactionService.create(transactionRequest);

        //then
        assertSame(transactionRequest, actual);
    }

    @Test
    void should_remove_todo_when_delete_given_id(){
        //given
        Transaction transactionRequest = new Transaction();
        transactionRequest.setTransactionId(69);

        //when
        transactionService.deleteTransaction(transactionRequest.getTransactionId());

        //then
        verify(transactionRepository, times(1)).deleteById(69);
    }

    @Test
    void should_return_done_todos_when_filtered_by_isDone_given_true() {
        //given
        Transaction transacition1 = new Transaction();
        transacition1.setUserId(69);
        Transaction transacition2 = new Transaction();
        transacition2.setUserId(69);

        //when
        when(transactionRepository.findAll()).thenReturn(asList(transacition1, transacition2));
        when(transactionRepository.findByUserId(69)).thenReturn(Collections.singletonList(transacition1));
        List<Transaction> actual = transactionService.getAllTransactionsByUser(69);

        //then
        assertEquals(1, actual.size());
    }

    @Test
    void should_return_done_todos_when_filtered_by_ticket() {
        //given
        Transaction transacition1 = new Transaction();
        transacition1.setTicketId(69);

        //when
        when(transactionRepository.findByTicketId(69)).thenReturn(transacition1);
        Transaction actual = transactionService.getTransactionByTicket(69);

        //then
        assertEquals(69, actual.getTicketId());
    }
}

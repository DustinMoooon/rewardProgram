package com.example.demo.service;

import com.example.demo.model.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction findByTransactionId(long id);
    List<Transaction> findByCustomerId(long customerId);
    Transaction saveTransaction(Transaction transaction);
    Transaction updateTransaction(Transaction transaction);
    void deleteTransactionByTransactionId(long id);
    void deleteTransactionByCustomerId(long id);
}

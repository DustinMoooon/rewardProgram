package com.example.demo.controller;

import com.example.demo.model.Transaction;
import com.example.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/transactions")
public class TransactionController {
    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable long id) {
        Transaction transaction = transactionService.findByTransactionId(id);
        return new ResponseEntity<>(transaction,HttpStatus.OK);
    }

    // Get all transactions for a customer
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Transaction>> getTransactionsByCustomerId(@PathVariable long customerId) {
        List<Transaction> transactions = transactionService.findByCustomerId(customerId);
        return new ResponseEntity<>(transactions,HttpStatus.OK);
    }

    // Create a new transaction
    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@Validated @RequestBody Transaction transaction) {
        Transaction createdTransaction = transactionService.saveTransaction(transaction);
        return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
    }

    // Update an existing transaction
    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable long id, @Validated @RequestBody Transaction transaction) {
        // Ensure the provided ID matches the path variable
        if (id != transaction.getTransactionId()) {
            return ResponseEntity.badRequest().build();
        }

        Transaction updatedTransaction = transactionService.updateTransaction(transaction);
        if (updatedTransaction != null) {
            return ResponseEntity.ok(updatedTransaction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a transaction by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransactionById(@PathVariable long id) {
        transactionService.deleteTransactionByTransactionId(id);
        return ResponseEntity.noContent().build();
    }

    // Delete all transactions for a customer
    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<Void> deleteTransactionsByCustomerId(@PathVariable long customerId) {
        transactionService.deleteTransactionByCustomerId(customerId);
        return ResponseEntity.noContent().build();
    }



}

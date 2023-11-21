package com.example.demo.service;

import com.example.demo.dao.TransactionRepository;
import com.example.demo.enitity.TransactionEntity;
import com.example.demo.model.Transaction;
import com.example.demo.util.TransactionEntityVoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.util.TransactionEntityVoConverter.convertEntityToVo;
import static com.example.demo.util.TransactionEntityVoConverter.convertVoToEntity;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepo;

    @Override
    public Transaction findByTransactionId(long id) {
        TransactionEntity transactionEntity=transactionRepo.findById(id).orElse(null);
        return convertEntityToVo(transactionEntity);
    }

    @Override
    public List<Transaction> findByCustomerId(long customerId) {
        List<TransactionEntity> transactionEntities = transactionRepo.findByCustomerId(customerId);
        return transactionEntities.stream()
                .map(entity -> convertEntityToVo(entity))
                .collect(Collectors.toList());
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        TransactionEntity transactionEntity = transactionRepo.saveAndFlush(convertVoToEntity(transaction));
        return convertEntityToVo(transactionEntity);
    }

    @Override
    public Transaction updateTransaction(Transaction transaction) {

        if (transactionRepo.existsById(transaction.getTransactionId())) {

            TransactionEntity entityToUpdate = convertVoToEntity(transaction);

            TransactionEntity updatedEntity = transactionRepo.saveAndFlush(entityToUpdate);

            return convertEntityToVo(updatedEntity);
        } else {
            return null;
        }
    }

    @Override
    public void deleteTransactionByTransactionId(long id) {
        transactionRepo.deleteById(id);
    }

    @Override
    public void deleteTransactionByCustomerId(long id) {

    }
}

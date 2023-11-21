package com.example.demo.util;

import com.example.demo.enitity.TransactionEntity;
import com.example.demo.model.Transaction;

public class TransactionEntityVoConverter {
    public static Transaction convertEntityToVo(TransactionEntity entity){
        if(entity==null) return null;
        Transaction transaction=new Transaction();
        transaction.setTransactionId(entity.getTransactionId());
        transaction.setCustomerId(entity.getCustomerId());
        transaction.setTransactionDate(entity.getTransactionDate());
        transaction.setTransactionAmount(entity.getTransactionAmount());
        transaction.setRewardPoints(entity.getRewardPoints());
        return transaction;
    }
    public static TransactionEntity convertVoToEntity(Transaction transaction){
        if(transaction==null) return null;
        return new TransactionEntity(transaction.getTransactionId(),transaction.getCustomerId(),transaction.getTransactionAmount(),transaction.getTransactionDate(), transaction.getRewardPoints());
    }
}

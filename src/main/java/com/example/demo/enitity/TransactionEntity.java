package com.example.demo.enitity;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "Transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="transactionId")
    private Long transactionId;
    @Column(name  ="customerId")
    private Long customerId;
    @Column(name  ="transactionAmount")
    private int transactionAmount;
    @Column(name  ="transactionDate")
    private Date transactionDate;
    @Column(name  ="rewardPoints")
    private int rewardPoints;

    public TransactionEntity() {
    }


    public TransactionEntity(Long transactionId, Long customerId, int transactionAmount, Date transactionDate, int rewardPoints) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
        this.rewardPoints = rewardPoints;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public int getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }
}

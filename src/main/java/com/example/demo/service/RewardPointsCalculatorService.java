package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class RewardPointsCalculatorService {

    public int calculateRewardPoints(int transactionAmount) {
        int points = 0;

        // Calculate points for every dollar spent over $100
        if (transactionAmount > 100) {
            points += (transactionAmount - 100) * 2;
        }

        // Calculate additional points for every dollar spent over $50
        if (transactionAmount > 50) {
            points += Math.min(transactionAmount - 50, 50);  // Up to $50, earn 1 point for each dollar
        }

        return points;
    }
}
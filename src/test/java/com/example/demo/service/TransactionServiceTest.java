package com.example.demo.service;

import com.example.demo.dao.TransactionRepository;
import com.example.demo.enitity.TransactionEntity;
import com.example.demo.model.Transaction;
import com.example.demo.service.TransactionService;
import com.example.demo.util.TransactionEntityVoConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionService transactionService;

    @Test
    public void testSaveTransaction() {

        Transaction mockTransaction = new Transaction(1L, 123L, 100, new Date(), 10);
        TransactionEntity mockTransactionEntity = TransactionEntityVoConverter.convertVoToEntity(mockTransaction);

        when(transactionRepository.save(any(TransactionEntity.class))).thenReturn(mockTransactionEntity);

        Transaction result = transactionService.saveTransaction(mockTransaction);

        assertNotNull(result);
        assertEquals(mockTransaction.getTransactionId(), result.getTransactionId());
        verify(transactionRepository).save(any(TransactionEntity.class));
    }
}

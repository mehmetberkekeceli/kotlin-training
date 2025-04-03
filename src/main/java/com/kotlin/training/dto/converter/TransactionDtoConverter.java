package com.kotlin.training.dto.converter;

import com.kotlin.training.dto.TransactionDto;
import com.kotlin.training.model.Transaction;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TransactionDtoConverter {

    public TransactionDto convert(Transaction from) {
        return new TransactionDto(Objects.requireNonNull(from.getId()).toString(),
                from.getTransactionType(),
                from.getAmount(),
                from.getTransactionDate());
    }
}
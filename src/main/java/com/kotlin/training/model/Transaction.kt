package com.kotlin.training.model;

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@Entity
data class Transaction(

    @Id
    @GeneratedValue
    val id: UUID? = null,

    @Enumerated(EnumType.STRING)
    val transactionType: TransactionType = TransactionType.INITIAL,

    val amount: BigDecimal,

    val transactionDate: LocalDateTime,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    val account: Account
) {
    constructor(
        amount: BigDecimal,
        transactionDate: LocalDateTime,
        account: Account
    ) : this(
        id = null,
        amount = amount,
        transactionDate = transactionDate,
        transactionType = TransactionType.INITIAL,
        account = account
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Transaction) return false
        return id == other.id
    }

    override fun hashCode(): Int = id?.hashCode() ?: 0
}

enum class TransactionType {
    INITIAL, TRANSFER
}

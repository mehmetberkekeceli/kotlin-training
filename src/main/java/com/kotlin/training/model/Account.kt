package com.kotlin.training.model;

import com.kotlin.training.model.Customer
import com.kotlin.training.model.Transaction
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*
import java.util.Collections.emptySet

@Entity
data class Account(

    @Id
    @GeneratedValue
    val id: UUID? = null,

    val balance: BigDecimal = BigDecimal.ZERO,

    val creationDate: LocalDateTime,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "customer_id", nullable = false)
    val customer: Customer,

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    val transaction: Set<Transaction> = emptySet()
) {

    constructor(
        customer: Customer,
        balance: BigDecimal,
        creationDate: LocalDateTime
    ) : this(
        id = null,
        customer = customer,
        balance = balance,
        creationDate = creationDate
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Account) return false
        return id == other.id
    }

    override fun hashCode(): Int = id?.hashCode() ?: 0
}

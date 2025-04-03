package com.kotlin.training.model;

import com.kotlin.training.model.Account
import jakarta.persistence.*
import java.util.*
import java.util.Collections.emptySet

@Entity
data class Customer(

    @Id
    @GeneratedValue
    val id: UUID? = null,

    val name: String,

    val surname: String,

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    val accounts: Set<Account> = emptySet()
) {

    constructor(name: String, surname: String) : this(
        id = null,
        name = name,
        surname = surname,
        accounts = emptySet()
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Customer) return false
        return id == other.id
    }

    override fun hashCode(): Int = id?.hashCode() ?: 0
}

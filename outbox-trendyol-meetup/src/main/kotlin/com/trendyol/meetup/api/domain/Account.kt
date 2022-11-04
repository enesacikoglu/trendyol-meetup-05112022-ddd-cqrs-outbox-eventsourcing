package com.trendyol.meetup.api.domain

import com.trendyol.meetup.api.application.exceptions.BusinessException
import com.trendyol.meetup.api.domain.events.AccountCreatedEvent
import com.trendyol.meetup.api.domain.events.MoneyWithdrawnEvent
import java.math.BigDecimal
import java.math.RoundingMode
import javax.persistence.*

@Entity
@Table(name = "account")
data class Account(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    override var id: Int = 0,
    var owner: String = "",
    var balance: BigDecimal = BigDecimal.ZERO.setScale(2),
    override var version: Int = 0
) : AggregateRoot<Account>(id, version) {

    fun create(owner: String, balance: BigDecimal): Account {
        val account = Account(0, owner, balance.setScale(2, RoundingMode.HALF_DOWN))
        val copy = account.copy()
        copy.id = 1
        account.registerEvent(AccountCreatedEvent(1, account.version, copy))
        return account
    }

    fun add(amount: BigDecimal) {
        this.balance = this.balance.add(amount).setScale(2, RoundingMode.HALF_DOWN)
        this.version = version++
    }

    fun withdraw(amount: BigDecimal) {
        val currentBalance = this.balance.subtract(amount)
        if (currentBalance < BigDecimal.ZERO) {
            throw BusinessException("Account has not got enough balance")
        }
        this.balance = currentBalance.setScale(2, RoundingMode.HALF_DOWN)
        this.version = this.version + 1
        this.registerEvent(MoneyWithdrawnEvent(this.id, this.version, this))
    }
}
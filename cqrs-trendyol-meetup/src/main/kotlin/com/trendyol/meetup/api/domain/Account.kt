package com.trendyol.meetup.api.domain

import com.trendyol.meetup.api.application.exceptions.BusinessException
import java.math.BigDecimal
import java.math.RoundingMode
import javax.persistence.*

@Entity
@Table(name = "account")
data class Account(@Id @GeneratedValue(strategy = GenerationType.AUTO)
                   var id: Int = 0,
                   var owner: String = "",
                   var balance: BigDecimal = BigDecimal.ZERO.setScale(2),
                   @Version
                   private val version: Long = 0L) {

    companion object {
        fun new(owner: String, balance: BigDecimal): Account {
            return Account(0, owner, balance.setScale(2, RoundingMode.HALF_DOWN), 0L)
        }
    }

    fun add(amount: BigDecimal) {
        this.balance = this.balance.add(amount).setScale(2, RoundingMode.HALF_DOWN)
    }

    fun withdraw(amount: BigDecimal) {
        val currentBalance = this.balance.subtract(amount)
        if (currentBalance < BigDecimal.ZERO) {
            throw BusinessException("Account has not got enough balance")
        }
        this.balance = currentBalance.setScale(2, RoundingMode.HALF_DOWN)
    }
}
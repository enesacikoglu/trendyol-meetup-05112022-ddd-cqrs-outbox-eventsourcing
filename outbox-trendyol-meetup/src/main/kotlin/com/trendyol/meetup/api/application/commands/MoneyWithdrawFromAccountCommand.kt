package com.trendyol.meetup.api.application.commands

import java.math.BigDecimal

import com.trendyol.kediatr.Command

data class MoneyWithdrawFromAccountCommand(val id: Int, val amount: BigDecimal) : Command
package com.trendyol.meetup.api.application.commands

import java.math.BigDecimal

import com.trendyol.kediatr.Command

data class CreateAccountCommand(val owner: String, val balance: BigDecimal) : Command
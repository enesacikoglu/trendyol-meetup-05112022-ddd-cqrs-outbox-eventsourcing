package com.trendyol.meetup.api.application.queries

import java.math.BigDecimal

data class GetAccountByIdResponse(val id: Int,
                                  val owner: String,
                                  val balance: BigDecimal
)
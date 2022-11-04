package com.trendyol.meetup.api.application.queries

import com.trendyol.kediatr.Query

data class GetAccountByIdQuery(val accountId: Int) : Query<GetAccountByIdResponse?>

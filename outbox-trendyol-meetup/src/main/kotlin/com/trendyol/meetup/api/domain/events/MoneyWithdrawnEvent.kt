package com.trendyol.meetup.api.domain.events

import com.trendyol.meetup.api.domain.Account

class MoneyWithdrawnEvent(
    override var id: Int,
    override var version: Int,
    override var payload: Account
) : DomainEvent<Account> {
    override fun getType(): String = "MoneyWithdrawnEvent"
}
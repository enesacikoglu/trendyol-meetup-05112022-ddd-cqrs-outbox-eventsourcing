package com.trendyol.meetup.api.application.persistence

import com.trendyol.meetup.api.domain.Account
import com.trendyol.meetup.api.domain.Outbox
import java.util.*

interface OutboxRepository {
    fun findById(id: Int): Optional<Outbox>
    fun save(entity: Outbox)
}
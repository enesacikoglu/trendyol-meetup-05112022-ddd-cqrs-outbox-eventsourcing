package com.trendyol.meetup.api.application.persistence

import com.trendyol.meetup.api.domain.Account
import java.util.*

interface AccountRepository {
    fun findById(id: Int): Optional<Account>
    fun save(entity: Account)
}
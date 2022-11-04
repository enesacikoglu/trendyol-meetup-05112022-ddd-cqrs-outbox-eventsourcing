package com.trendyol.meetup.api.infrastructure.persistence


import com.fasterxml.jackson.databind.ObjectMapper
import com.trendyol.meetup.api.application.persistence.AccountRepository
import com.trendyol.meetup.api.domain.Account
import com.trendyol.meetup.api.domain.Outbox
import com.trendyol.meetup.api.domain.events.DomainEvent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*
import javax.persistence.EntityManager
import javax.transaction.Transactional

@Component
class AccountRepositoryImp(private val entityManager: EntityManager) : AccountRepository {
    @Transactional
    override fun save(entity: Account) {
        entityManager.merge(entity)
        val events: List<DomainEvent<Account>> = entity.events()
        val payload = ObjectMapper().writeValueAsString(events)
        if (events.isNotEmpty()) {
            val outbox = Outbox.new(payload)
            outbox.version = entity.version
            //Persist events to outbox
            entityManager.persist(outbox)
        }
    }

    override fun findById(id: Int): Optional<Account> {
        return Optional.ofNullable(
            entityManager
                .find(Account::class.java, id)
        )
    }
}
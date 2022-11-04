package com.trendyol.meetup.api.infrastructure.persistence



import com.trendyol.meetup.api.application.persistence.OutboxRepository
import com.trendyol.meetup.api.domain.Account
import com.trendyol.meetup.api.domain.Outbox

import org.springframework.stereotype.Component
import java.util.*
import javax.persistence.EntityManager
import javax.transaction.Transactional

@Component
class OutboxRepositoryImp(private val entityManager: EntityManager) : OutboxRepository {
    @Transactional
    override fun save(entity: Outbox) {
        entityManager.persist(entity)
    }

    override fun findById(id: Int): Optional<Outbox> {
        return Optional.ofNullable(
            entityManager
                .find(Outbox::class.java, id)
        )
    }
}
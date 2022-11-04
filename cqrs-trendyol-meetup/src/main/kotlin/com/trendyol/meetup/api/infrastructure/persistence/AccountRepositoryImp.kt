package com.trendyol.meetup.api.infrastructure.persistence


import com.trendyol.meetup.api.application.persistence.AccountRepository
import com.trendyol.meetup.api.domain.Account
import org.springframework.stereotype.Component
import java.util.*
import javax.persistence.EntityManager
import javax.transaction.Transactional

@Component
class AccountRepositoryImp(private val entityManager: EntityManager) : AccountRepository {

    @Transactional
    override fun save(entity: Account) {
        entityManager.persist(entity)
    }

    override fun findById(id: Int): Optional<Account> {
        return Optional.ofNullable(
            entityManager
                .find(Account::class.java, id)
        )
    }
}
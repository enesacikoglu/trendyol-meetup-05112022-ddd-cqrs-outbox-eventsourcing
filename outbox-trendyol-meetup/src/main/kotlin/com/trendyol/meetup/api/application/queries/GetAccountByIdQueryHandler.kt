package com.trendyol.meetup.api.application.queries

import com.trendyol.kediatr.QueryHandler
import com.trendyol.meetup.api.application.exceptions.DomainNotFoundException
import com.trendyol.meetup.api.domain.Account
import org.springframework.stereotype.Component
import java.util.*
import javax.persistence.EntityManager

@Component
    class GetAccountByIdQueryHandler(private val entityManager: EntityManager)
    : QueryHandler<GetAccountByIdResponse?, GetAccountByIdQuery> {
    override fun handle(query: GetAccountByIdQuery): GetAccountByIdResponse? {
        with(query) {
            val account =  Optional.ofNullable(entityManager
                    .createQuery("Select a from Account a where a.id = :id", Account::class.java)
                    .setParameter("id",query.accountId)
                    .singleResult)
                    .orElseThrow { throw DomainNotFoundException("account not found!") }
            return GetAccountByIdResponse(accountId, account.owner, account.balance)
        }
    }
} 
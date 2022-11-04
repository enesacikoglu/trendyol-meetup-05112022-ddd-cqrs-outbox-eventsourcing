package com.trendyol.meetup.api.application.commands


import com.fasterxml.jackson.databind.ObjectMapper
import com.trendyol.kediatr.CommandHandler
import com.trendyol.meetup.api.application.persistence.AccountRepository
import com.trendyol.meetup.api.domain.Account
import com.trendyol.meetup.api.domain.Outbox
import com.trendyol.meetup.api.domain.events.DomainEvent
import com.trendyol.meetup.api.domain.events.MoneyWithdrawnEvent
import org.springframework.stereotype.Component

@Component
class CreateAccountCommandHandler(private val accountRepository: AccountRepository) :
    CommandHandler<CreateAccountCommand> {

    override fun handle(command: CreateAccountCommand) {
        accountRepository.save(Account().create(command.owner, command.balance))
    }
}
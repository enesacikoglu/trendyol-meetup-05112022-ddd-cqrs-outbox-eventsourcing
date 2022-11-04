package com.trendyol.meetup.api.application.commands


import com.fasterxml.jackson.databind.ObjectMapper
import com.trendyol.kediatr.CommandHandler
import com.trendyol.meetup.api.application.exceptions.BusinessException
import com.trendyol.meetup.api.application.persistence.AccountRepository
import com.trendyol.meetup.api.application.persistence.OutboxRepository
import com.trendyol.meetup.api.domain.Account
import com.trendyol.meetup.api.domain.Outbox
import com.trendyol.meetup.api.domain.events.DomainEvent
import org.springframework.stereotype.Component


@Component
class MoneyWithdrawnFromAccountCommandHandler(
    private val accountRepository: AccountRepository,
    private val outboxRepository: OutboxRepository
) :
    CommandHandler<MoneyWithdrawFromAccountCommand> {

    override fun handle(command: MoneyWithdrawFromAccountCommand) {
        val account: Account = accountRepository.findById(command.id)
            .orElseThrow()
        account.withdraw(command.amount)
        accountRepository.save(account)
    }
}
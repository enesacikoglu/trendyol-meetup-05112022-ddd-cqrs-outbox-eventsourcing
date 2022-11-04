package com.trendyol.meetup.api.application.commands


import com.trendyol.kediatr.CommandHandler
import com.trendyol.meetup.api.application.persistence.AccountRepository
import com.trendyol.meetup.api.domain.Account
import org.springframework.stereotype.Component

@Component
class CreateAccountCommandHandler(private val accountRepository: AccountRepository) :
    CommandHandler<CreateAccountCommand> {

    override fun handle(command: CreateAccountCommand) {
        accountRepository.save(Account.new(command.owner, command.balance))
    }
}
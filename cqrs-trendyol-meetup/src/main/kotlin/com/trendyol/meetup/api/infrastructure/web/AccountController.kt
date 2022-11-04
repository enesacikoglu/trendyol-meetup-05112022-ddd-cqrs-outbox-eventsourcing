package com.trendyol.meetup.api.infrastructure.web

import com.trendyol.kediatr.CommandBus
import com.trendyol.meetup.api.application.commands.CreateAccountCommand
import com.trendyol.meetup.api.application.queries.GetAccountByIdQuery
import com.trendyol.meetup.api.application.queries.GetAccountByIdResponse
import org.springframework.web.bind.annotation.*


@RequestMapping("/accounts")
@RestController
class AccountController(private val commandBus: CommandBus) {

    @GetMapping("/{accountId}")
    fun getAccountById(@PathVariable("accountId") accountId: Int): GetAccountByIdResponse? {
        return commandBus.executeQuery(GetAccountByIdQuery(accountId))
    }

    @PostMapping
    fun createAccount(@RequestBody createAccountCommand: CreateAccountCommand) {
        commandBus.executeCommand(createAccountCommand)
    }

}
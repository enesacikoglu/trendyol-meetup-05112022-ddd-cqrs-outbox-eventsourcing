package com.trendyol.meetup.api.application.exceptions

data class DomainNotFoundException(override var message: String) : RuntimeException(message)

package com.trendyol.meetup.api.application.exceptions

data class BusinessException(override var message: String) : RuntimeException(message)

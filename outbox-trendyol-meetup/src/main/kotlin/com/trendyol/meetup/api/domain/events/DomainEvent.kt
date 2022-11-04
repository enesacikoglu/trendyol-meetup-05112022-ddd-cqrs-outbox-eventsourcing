package com.trendyol.meetup.api.domain.events

import com.trendyol.meetup.api.domain.AggregateRoot

interface DomainEvent<T : AggregateRoot<T>> {
    var id: Int
    var version: Int
    var payload: T
    fun getType() :String
}

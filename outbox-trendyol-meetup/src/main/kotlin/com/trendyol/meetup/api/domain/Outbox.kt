package com.trendyol.meetup.api.domain

import javax.persistence.*


@Entity
@Table(name = "outbox")
data class Outbox(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    override var id: Int = 0,
    val event: String = "",
    override var version: Int = 0
) : AggregateRoot<Outbox>(id, version) {

    companion object {
        fun new(event: String): Outbox {
            return Outbox(0, event)
        }
    }

}
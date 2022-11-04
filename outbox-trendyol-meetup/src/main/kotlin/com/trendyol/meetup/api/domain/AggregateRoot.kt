package com.trendyol.meetup.api.domain

import com.trendyol.meetup.api.domain.events.DomainEvent
import org.springframework.util.Assert
import java.time.Instant

abstract class AggregateRoot<A : AggregateRoot<A>>(open val id: Int,open val version: Int) {
    var modifiedDate: Instant? = Instant.now()

    private val events: MutableList<DomainEvent<A>> = mutableListOf()

    /**
     * Registers the given event object for publication on a call to a repository's save methods.
     *
     * @param event must not be null.
     * @return the event that has been added.
     * @see .andEvent
     */
    protected fun <T : DomainEvent<A>> registerEvent(event: T): T {
        Assert.notNull(event, "Domain event must not be null!")
        events.add(event)
        return event
    }

    /**
     * Clears all domain events currently held. Usually invoked by the infrastructure in place in Spring Data
     * repositories.
     */
    fun clearEvents() {
        events.clear()
    }

    /**
     * All domain events currently captured by the aggregate.
     */
    fun events(): List<DomainEvent<A>> = events
}

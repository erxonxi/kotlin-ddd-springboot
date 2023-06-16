package es.rubenruizpedreira.backend.contexts.shared.domain

abstract class Aggregate() {
    private var domainEvents: MutableList<DomainEvent>

    init {
        domainEvents = ArrayList()
    }

    fun pullDomainEvents(): List<DomainEvent> {
        val events: List<DomainEvent> = domainEvents
        domainEvents = ArrayList()
        return events
    }

    fun record(domainEvent: DomainEvent) {
        domainEvents.add(domainEvent)
    }

    abstract fun toPrimitive(): AggregatePrimitive
}
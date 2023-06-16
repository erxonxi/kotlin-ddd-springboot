package es.rubenruizpedreira.backend.contexts.shared.domain

interface EventBus {
    fun publish(event: DomainEvent)
    fun publish(events: List<DomainEvent>)
}
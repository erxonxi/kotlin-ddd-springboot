package es.rubenruizpedreira.backend.contexts.shared.domain

abstract class DomainEvent {
    abstract fun eventName(): String
    abstract fun eventJson(): String
}
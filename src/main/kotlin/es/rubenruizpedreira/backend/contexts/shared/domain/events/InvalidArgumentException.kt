package es.rubenruizpedreira.backend.contexts.shared.domain.events

open class InvalidArgumentException(message: String) : Throwable() {
    override val message: String = "Invalid argument: $message"
}
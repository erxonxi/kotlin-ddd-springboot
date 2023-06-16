package es.rubenruizpedreira.backend.contexts.users.domain.events

import es.rubenruizpedreira.backend.contexts.shared.domain.DomainEvent

class UserCreatedEvent(
    val id: String,
    val email: String,
    val password: String,
) : DomainEvent() {
    companion object {
        const val EVENT_NAME = "user.created"
    }

    override fun eventName(): String {
        return EVENT_NAME
    }

    override fun eventJson(): String {
        return """
            {
                "id": "$id",
                "email": "$email",
                "password": "$password"
            }
        """.trimIndent()
    }
}
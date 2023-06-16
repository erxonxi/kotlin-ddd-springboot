package es.rubenruizpedreira.backend.contexts.users.domain.events

import es.rubenruizpedreira.backend.contexts.shared.domain.DomainEvent

class UserDeletedEvent(
    val id: String,
) : DomainEvent() {
    override fun eventName(): String {
        return "user.deleted"
    }

    override fun eventJson(): String {
        return """
            {
                "id": "$id"
            }
        """.trimIndent()
    }
}
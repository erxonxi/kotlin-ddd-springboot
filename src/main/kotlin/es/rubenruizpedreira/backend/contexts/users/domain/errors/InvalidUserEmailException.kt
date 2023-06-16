package es.rubenruizpedreira.backend.contexts.users.domain.errors

import es.rubenruizpedreira.backend.contexts.shared.domain.events.InvalidArgumentException

class InvalidUserEmailException(email: String) : InvalidArgumentException(email) {
    override val message: String = "Invalid email: $email"
}

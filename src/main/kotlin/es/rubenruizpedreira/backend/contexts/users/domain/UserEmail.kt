package es.rubenruizpedreira.backend.contexts.users.domain

import es.rubenruizpedreira.backend.contexts.users.domain.errors.InvalidUserEmailException

data class UserEmail(val value: String) {
    init {
        if (!value.contains("@")) {
            throw InvalidUserEmailException("Invalid email")
        }
    }
}

package es.rubenruizpedreira.backend.contexts.users.domain

import es.rubenruizpedreira.backend.contexts.shared.domain.events.InvalidArgumentException

data class UserPassword(val value: String) {
    init {
        if (value.length < 8) {
            throw InvalidArgumentException(value)
        }
    }
}
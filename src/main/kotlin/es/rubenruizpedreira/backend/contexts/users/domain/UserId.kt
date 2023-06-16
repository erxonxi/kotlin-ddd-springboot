package es.rubenruizpedreira.backend.contexts.users.domain

import java.util.*

data class UserId(val value: String) {
    init {
        UUID.fromString(value)
    }

    override fun toString(): String {
        return value
    }
}

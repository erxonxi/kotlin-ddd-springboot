package es.rubenruizpedreira.backend.contexts.users.domain

import es.rubenruizpedreira.backend.contexts.shared.domain.AggregatePrimitive

data class UserPrimitive(
    val id: String,
    val email: String,
    val password: String,
) : AggregatePrimitive()
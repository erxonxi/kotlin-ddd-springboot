package es.rubenruizpedreira.backend.contexts.users.domain

import es.rubenruizpedreira.backend.contexts.shared.domain.Aggregate

class User(
    val id: UserId,
    val email: UserEmail,
    val password: UserPassword,
) : Aggregate() {
    companion object {
        fun fromPrimitive(primitive: UserPrimitive): User {
            return User(
                id = UserId(primitive.id),
                email = UserEmail(primitive.email),
                password = UserPassword(primitive.password),
            )
        }
    }

    override fun toPrimitive(): UserPrimitive {
        return UserPrimitive(
            id = id.value,
            email = email.value,
            password = password.value,
        )
    }
}
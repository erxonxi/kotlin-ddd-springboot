package es.rubenruizpedreira.backend.contexts.users.domain

import es.rubenruizpedreira.backend.contexts.shared.domain.Aggregate
import es.rubenruizpedreira.backend.contexts.users.domain.events.UserCreatedEvent

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

        fun create(id: UserId, email: UserEmail, password: UserPassword): User {
            val user = User(id, email, password)
            user.record(UserCreatedEvent(id.value, email.value, password.value))
            return user
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
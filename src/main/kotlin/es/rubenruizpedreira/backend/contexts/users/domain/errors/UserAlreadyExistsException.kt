package es.rubenruizpedreira.backend.contexts.users.domain.errors

class UserAlreadyExistsException : Exception() {
    override val message: String = "User already exists"
}
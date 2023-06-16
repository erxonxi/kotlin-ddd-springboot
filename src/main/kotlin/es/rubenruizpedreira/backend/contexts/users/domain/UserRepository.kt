package es.rubenruizpedreira.backend.contexts.users.domain

interface UserRepository {
    fun save(user: User)
    fun find(id: UserId): User?
    fun find(email: UserEmail): User?
    fun delete(id: UserId)
}
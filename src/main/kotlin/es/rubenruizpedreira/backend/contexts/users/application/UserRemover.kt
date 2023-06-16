package es.rubenruizpedreira.backend.contexts.users.application

import es.rubenruizpedreira.backend.contexts.users.domain.UserId
import es.rubenruizpedreira.backend.contexts.users.domain.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserRemover @Autowired constructor(private val repository: UserRepository) {
    fun execute(id: UserId) {
        this.repository.delete(id)
    }
}
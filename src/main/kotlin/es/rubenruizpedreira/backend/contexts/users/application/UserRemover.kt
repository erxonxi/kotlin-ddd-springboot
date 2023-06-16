package es.rubenruizpedreira.backend.contexts.users.application

import es.rubenruizpedreira.backend.contexts.shared.domain.EventBus
import es.rubenruizpedreira.backend.contexts.users.domain.UserId
import es.rubenruizpedreira.backend.contexts.users.domain.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserRemover @Autowired constructor(private val repository: UserRepository, private val eventBus: EventBus) {
    fun execute(id: UserId) {
        val user = this.repository.find(id) ?: return

        this.repository.delete(id)
        this.eventBus.publish(user.pullDomainEvents())
    }
}
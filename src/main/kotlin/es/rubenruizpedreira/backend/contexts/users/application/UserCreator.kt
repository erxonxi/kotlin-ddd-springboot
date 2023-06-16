package es.rubenruizpedreira.backend.contexts.users.application

import es.rubenruizpedreira.backend.contexts.shared.domain.EventBus
import es.rubenruizpedreira.backend.contexts.users.domain.*
import es.rubenruizpedreira.backend.contexts.users.domain.errors.UserAlreadyExistsException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserCreator @Autowired constructor(private val repository: UserRepository, private val eventBus: EventBus) {
    fun execute(id: UserId, email: UserEmail, password: UserPassword) {
        val checkExists = repository.find(email)

        if (checkExists != null) {
            throw UserAlreadyExistsException()
        }

        val user = User.create(id, email, password)
        repository.save(user)
        this.eventBus.publish(user.pullDomainEvents())
    }
}
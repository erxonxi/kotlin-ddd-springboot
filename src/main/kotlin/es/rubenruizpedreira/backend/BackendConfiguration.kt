package es.rubenruizpedreira.backend

import es.rubenruizpedreira.backend.contexts.shared.domain.EventBus
import es.rubenruizpedreira.backend.contexts.shared.infrastructure.RabbitMqEventBus
import es.rubenruizpedreira.backend.contexts.users.domain.UserRepository
import es.rubenruizpedreira.backend.contexts.users.domain.events.UserCreatedEvent
import es.rubenruizpedreira.backend.contexts.users.infrastructure.MongoUserRepository
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.MongoDatabaseFactory
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory

@Configuration
class BackendConfiguration {

    @Value("\${spring.data.mongodb.uri}")
    private lateinit var mongoUri: String

    @Bean
    fun mongoDatabaseFactory(): MongoDatabaseFactory {
        return SimpleMongoClientDatabaseFactory(mongoUri)
    }

    @Bean
    fun mongoTemplate(dbFactory: MongoDatabaseFactory): MongoTemplate {
        return MongoTemplate(dbFactory)
    }

    @Bean
    fun userRepository(operations: MongoOperations): UserRepository {
        return MongoUserRepository(operations)
    }

    @Bean
    fun eventBus(rabbitTemplate: RabbitTemplate): EventBus {
        return RabbitMqEventBus(rabbitTemplate)
    }

    @Bean
    fun queueUserCreatedDomainEvent(): Queue {
        return Queue(UserCreatedEvent.EVENT_NAME)
    }
}

package es.rubenruizpedreira.backend

import es.rubenruizpedreira.backend.contexts.users.domain.UserRepository
import es.rubenruizpedreira.backend.contexts.users.infrastructure.MongoUserRepository
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
}

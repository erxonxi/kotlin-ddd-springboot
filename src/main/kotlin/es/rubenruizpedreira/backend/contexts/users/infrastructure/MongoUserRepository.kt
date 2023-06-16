package es.rubenruizpedreira.backend.contexts.users.infrastructure

import es.rubenruizpedreira.backend.contexts.users.domain.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository

@Repository
@Profile("mongodb")
class MongoUserRepository @Autowired constructor(val operations: MongoOperations) : UserRepository {
    override fun save(user: User) {
        operations.save(user.toPrimitive(), "users")
    }

    override fun find(id: UserId): User? {
        val query = Query().addCriteria(Criteria.where("_id").`is`(id.value));

        val userPrimitive: UserPrimitive = operations.findOne(query, UserPrimitive::class.java, "users")
            ?: return null

        return User.fromPrimitive(userPrimitive)
    }

    override fun find(email: UserEmail): User? {
        val query = Query().addCriteria(Criteria.where("email").`is`(email.value));

        val userPrimitive: UserPrimitive = operations.findOne(query, UserPrimitive::class.java, "users")
            ?: return null

        return User.fromPrimitive(userPrimitive)
    }

    override fun delete(id: UserId) {
        operations.remove(Query().addCriteria(Criteria.where("_id").`is`(id.value)), "users")
    }
}
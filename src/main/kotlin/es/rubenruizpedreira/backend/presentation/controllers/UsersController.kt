package es.rubenruizpedreira.backend.presentation.controllers

import es.rubenruizpedreira.backend.contexts.users.domain.User
import es.rubenruizpedreira.backend.contexts.users.domain.UserId
import es.rubenruizpedreira.backend.contexts.users.domain.UserPrimitive
import es.rubenruizpedreira.backend.contexts.users.domain.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/users")
class UsersController @Autowired constructor(val repository: UserRepository) {
    @GetMapping
    fun getUsers(): String {
        return "Hello World"
    }

    @PostMapping
    fun createUser(@RequestBody body: CreateUserRequestBody): ResponseEntity<String> {
        val user = User.fromPrimitive(UserPrimitive(body.id, body.email, body.password))

        this.repository.save(user)

        return ResponseEntity.ok("User created successfully")
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: String): ResponseEntity<String> {
        this.repository.delete(UserId(id))

        return ResponseEntity.ok("User deleted successfully")
    }
}
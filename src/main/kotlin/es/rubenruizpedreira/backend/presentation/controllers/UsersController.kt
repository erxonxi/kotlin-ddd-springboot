package es.rubenruizpedreira.backend.presentation.controllers

import es.rubenruizpedreira.backend.contexts.users.application.UserCreator
import es.rubenruizpedreira.backend.contexts.users.application.UserRemover
import es.rubenruizpedreira.backend.contexts.users.domain.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/users")
class UsersController @Autowired constructor(
    private val creator: UserCreator,
    private val remover: UserRemover,
) {
    @PostMapping
    fun createUser(@RequestBody body: CreateUserRequestBody): ResponseEntity<String> {
        this.creator.execute(UserId(body.id), UserEmail(body.email), UserPassword(body.password))

        return ResponseEntity.ok("User created successfully")
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: String): ResponseEntity<String> {
        this.remover.execute(UserId(id))

        return ResponseEntity.ok("User deleted successfully")
    }
}
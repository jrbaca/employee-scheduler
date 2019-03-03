package com.josephbaca.employeescheduler.controller

import com.josephbaca.employeescheduler.model.User
import com.josephbaca.employeescheduler.model.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*


@RestController
class UserRestController(private val repository: UserRepository) {

    private val LOG = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/users")
    fun all(): List<User> {
        return repository.findAll();
    }

    @PostMapping("/users")
    fun newUser(@RequestBody newUser: User): User {
        LOG.info("making new user %s".format(newUser))
        return repository.save(newUser)
    }

    @GetMapping("/users/{id}")
    fun getUser(@PathVariable id: String): User {
        return repository.findById(id).orElseThrow { RuntimeException("User not found!") }
    }

    @DeleteMapping("/users/{id}")
    fun deleteUser(@PathVariable id: String) {
        repository.deleteById(id)
    }
}
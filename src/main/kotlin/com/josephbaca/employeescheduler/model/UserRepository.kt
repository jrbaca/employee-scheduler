package com.josephbaca.employeescheduler.model

import org.springframework.data.mongodb.repository.MongoRepository

/**
 * An interface for accessing [Users][User] in the backing MongoDB database.
 */
interface UserRepository : MongoRepository<User, String> {

    fun findByEmail(email: String): User?
}

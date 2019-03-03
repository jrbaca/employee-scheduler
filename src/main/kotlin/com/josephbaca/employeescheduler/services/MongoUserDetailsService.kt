package com.josephbaca.employeescheduler.services

import com.josephbaca.employeescheduler.model.UserRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

/**
 * Configures the authentication backend to use mongodb.
 */
@Component
class MongoUserDetailsService(private val repository: UserRepository) : UserDetailsService {

    override fun loadUserByUsername(email: String): UserDetails {
        val user = repository.findByEmail(email)
        if (user != null) {
            val authorities = listOf(SimpleGrantedAuthority("user"))
            return User(user.email, user.password, authorities)
        } else {
            throw UsernameNotFoundException("User not found")
        }
    }
}

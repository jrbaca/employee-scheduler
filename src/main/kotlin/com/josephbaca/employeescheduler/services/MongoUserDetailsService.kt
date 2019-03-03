package com.josephbaca.employeescheduler.services

import com.josephbaca.employeescheduler.model.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class MongoUserDetailsService(@Autowired private val repository: UserRepository) : UserDetailsService {


    override fun loadUserByUsername(email: String): UserDetails? {
        val user = repository.findByEmail(email)
        if (user != null) {
            val authorities = listOf(SimpleGrantedAuthority("user"))
            return org.springframework.security.core.userdetails.User(user.email, user.password, authorities)
        } else {
            throw UsernameNotFoundException("User not found")
        }
    }

}
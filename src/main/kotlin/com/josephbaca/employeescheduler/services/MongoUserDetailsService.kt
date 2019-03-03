package com.josephbaca.employeescheduler.services

import com.josephbaca.employeescheduler.model.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class MongoUserDetailsService : UserDetailsService {

    private val LOG = LoggerFactory.getLogger(this::class.java)

    @Autowired
    private val repository: UserRepository? = null

    override fun loadUserByUsername(username: String): UserDetails? {
        val user = repository!!.findByUsername(username)
        if (user != null) {
            val authorities = listOf(SimpleGrantedAuthority("user"))
            return org.springframework.security.core.userdetails.User(user.username, user.password, authorities)
        } else {
            throw UsernameNotFoundException("User not found")
        }
    }

}
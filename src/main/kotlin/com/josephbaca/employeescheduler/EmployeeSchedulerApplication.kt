package com.josephbaca.employeescheduler

import nz.net.ultraq.thymeleaf.LayoutDialect
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import com.josephbaca.employeescheduler.services.MongoUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder





@SpringBootApplication
class EmployeeSchedulerApplication

@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    var userDetailsService: MongoUserDetailsService? = null

    override fun configure(http: HttpSecurity) {
        http
                .authorizeRequests().antMatchers("/*.css", "/signup").permitAll().anyRequest().authenticated().and()
                .formLogin().loginPage("/login").permitAll().and()
                .logout().permitAll()
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.userDetailsService(userDetailsService)
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}

fun main(args: Array<String>) {
    runApplication<EmployeeSchedulerApplication>(*args)
}

@Bean
fun layoutDialect(): LayoutDialect {
    // configures Thymeleaf to use layout dialect
    return LayoutDialect()
}
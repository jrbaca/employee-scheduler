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
import com.josephbaca.employeescheduler.services.MongoUserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

/**
 * Creates the application and connects it to spring boot.
 */
@SpringBootApplication
class EmployeeSchedulerApplication

/**
 * Configures the security settings.
 * @param userDetailsService the connection to the user model in mongodb
 */
@Configuration
@EnableWebSecurity
class WebSecurityConfig(private val userDetailsService: MongoUserDetailsService) :
        WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http
                .authorizeRequests().antMatchers("/", "/*.css", "/signup").permitAll()
                .anyRequest().authenticated().and()
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

/**
 * Configures Thymeleaf to use layout dialect.
 */
@Bean
fun layoutDialect(): LayoutDialect {
    return LayoutDialect()
}

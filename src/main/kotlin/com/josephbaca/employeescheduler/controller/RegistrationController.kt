package com.josephbaca.employeescheduler.controller

import com.josephbaca.employeescheduler.model.User
import com.josephbaca.employeescheduler.model.UserDto
import com.josephbaca.employeescheduler.model.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.validation.BindingResult
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.ModelAndView
import javax.validation.Valid

/**
 * The registration controller maps the endpoints for signing up, logging in/out, etc.
 * @param repository Connection to the [User] model in the database by using [UserRepository]
 */
@Controller
class RegistrationController(
        private val repository: UserRepository,
        private val passwordEncoder: PasswordEncoder
) {

    private val LOG = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/signup")
    fun showRegistrationForm(request: WebRequest, model: Model): String {
        model["user"] = UserDto()
        return "user/signup"
    }

    @PostMapping("/signup")
    fun registerUserAccount(
        @ModelAttribute("user") @Valid accountDto: UserDto,
        result: BindingResult,
        request: WebRequest,
        errors: Errors
    ): ModelAndView {

        val newUser: User? = if (result.hasErrors()) null else createUserAccount(accountDto)

        if (newUser == null) {
            result.rejectValue("email", "message.regError")
        }

        return if (result.hasErrors()) {
            ModelAndView("user/signup", "user", accountDto)
        } else {
            ModelAndView("user/signupSuccess", "user", accountDto)
        }
    }

    /**
     * Attempts to create a user account. Returns null if the email already exists.
     */
    private fun createUserAccount(accountDto: UserDto): User? {
        return if (repository.findByEmail(accountDto.email) == null) {
            repository.save(User(
                    accountDto.firstName,
                    accountDto.lastName,
                    accountDto.email,
                    passwordEncoder!!.encode(accountDto.password)))
        } else null
    }

    @GetMapping("/login")
    fun login(): String {
        return "user/login"
    }
}

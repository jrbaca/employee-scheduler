package com.josephbaca.employeescheduler.controller

import com.josephbaca.employeescheduler.model.User
import com.josephbaca.employeescheduler.model.UserDto
import com.josephbaca.employeescheduler.model.UserRepository
import org.slf4j.LoggerFactory
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
import org.thymeleaf.spring5.util.FieldUtils.hasErrors




@Controller
class AuthController(private val repository: UserRepository) {

    private val LOG = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/signup")
    fun showRegistrationForm(request: WebRequest, model: Model): String {
        model["user"] = UserDto()
        return "user/signup"
    }

    @PostMapping("/signup")
    fun registerUserAccount(@ModelAttribute("user") @Valid accountDto: UserDto, result: BindingResult, request: WebRequest, errors: Errors): ModelAndView {
        LOG.info("signing up %s".format(accountDto))
        var registered: User? = null
        if (!result.hasErrors()) {
            registered = createUserAccount(accountDto)
        }
        if (registered == null) {
            result.rejectValue("email", "message.regError")
        }

        return if (result.hasErrors()) {
            ModelAndView("user/signup", "user", accountDto)
        } else {
            ModelAndView("landing", "user", accountDto)
        }
    }

    private fun createUserAccount(accountDto: UserDto): User? {
        if (repository.findByEmail(accountDto.email!!) != null) {
            return null;
        } else {
            val user = User(accountDto.firstName!!, accountDto.lastName!!, accountDto.email, accountDto.password!!)
            return repository.save(user)
        }
    }

    @GetMapping("/login")
    fun login(): String {
        return "user/login"
    }

//    @GetMapping("/signup")
//    fun showRegistrationForm(request: WebRequest, model: Model): String {
//        model["user"] = UserDto()
//        return "user/signup"
//    }
}
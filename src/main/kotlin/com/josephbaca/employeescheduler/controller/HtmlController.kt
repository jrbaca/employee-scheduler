package com.josephbaca.employeescheduler.controller

import com.josephbaca.employeescheduler.model.UserDto
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.context.request.WebRequest


@Controller
class HtmlController {

    @GetMapping("/")
    fun home(): String {
        return "landing"
    }

    @GetMapping("/dashboard")
    fun employerDashboard(): String {
        return "user/dashboard"
    }
}
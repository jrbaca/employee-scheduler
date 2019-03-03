package com.josephbaca.employeescheduler.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HtmlController {

    @GetMapping("/")
    fun home(): String {
        return "landing"
    }

    @GetMapping("/employer/login")
    fun employerLogin(): String {
        return "employer/login"
    }

    @GetMapping("/employer/dashboard")
    fun employerDashboard(): String {
        return "employer/dashboard"
    }
}
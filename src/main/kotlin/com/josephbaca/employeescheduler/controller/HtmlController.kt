package com.josephbaca.employeescheduler.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class HtmlController {

    @GetMapping("/")
    fun home(@RequestParam(name = "name", required = false, defaultValue = "World") name: String, model: Model): String {
        model["name"] = name
        return "landing"
    }

    @GetMapping("/employer/login")
    fun employerLogin(model: Model): String {
        return "employer/login"
    }

    @GetMapping("/employer/dashboard")
    fun employerDashboard(model: Model): String {
        return "employer/dashboard"
    }
}
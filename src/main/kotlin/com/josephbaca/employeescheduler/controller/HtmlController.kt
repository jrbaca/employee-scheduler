package com.josephbaca.employeescheduler.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

/**
 * Controller for mapping user endpoints that are not otherwise a part of other APIs.
 */
@Controller
class HtmlController {

    @GetMapping("/")
    fun landingPage(): String {
        return "landing"
    }

    @GetMapping("/dashboard")
    fun dashboard(): String {
        return "user/dashboard"
    }
}

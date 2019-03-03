package com.josephbaca.employeescheduler.model

import org.springframework.data.annotation.Id

class Employer(var name: String) {

    @Id
    var id: String? = null
}
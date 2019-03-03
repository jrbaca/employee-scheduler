package com.josephbaca.employeescheduler.model

import org.springframework.data.annotation.Id


class User(
        var firstName: String,
        var lastName: String,
        var email: String,
        var password: String) {

    @Id
    var id: String? = null // will be set by mongodb

}
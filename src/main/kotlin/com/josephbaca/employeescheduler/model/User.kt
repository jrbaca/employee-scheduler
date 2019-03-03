package com.josephbaca.employeescheduler.model

import org.springframework.data.annotation.Id


class User(var username: String, var password: String) {

    @Id
    var id: String? = null // will be set by mongodb

}
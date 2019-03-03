package com.josephbaca.employeescheduler.model

import org.springframework.data.annotation.Id

/**
 * A user that is registered with this application.
 */
class User(
    var firstName: String,
    var lastName: String,
    var email: String,
    var password: String
) {

    @Id
    lateinit var id: String
}

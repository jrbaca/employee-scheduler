package com.josephbaca.employeescheduler.model

import org.springframework.data.annotation.Id

class Employee(firstName: String, lastName: String) {

    @Id
    var id: String? = null

    var firstName: String? = firstName
    var lastName: String? = lastName

    override fun toString(): String {
        return String.format(
                "Employee[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName)
    }
}
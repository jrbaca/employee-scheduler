package com.josephbaca.employeescheduler.model

import com.josephbaca.employeescheduler.validation.ValidEmail
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

class UserDto {
    @NotNull
    @NotEmpty
    var firstName: String = ""

    @NotNull
    @NotEmpty
    var lastName: String = ""

    @NotNull
    @NotEmpty
    var password: String = ""
    var matchingPassword: String = ""

    @ValidEmail
    @NotNull
    @NotEmpty
    var email: String = ""
}
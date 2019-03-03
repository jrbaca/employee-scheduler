package com.josephbaca.employeescheduler.model

import com.josephbaca.employeescheduler.validation.ValidEmail
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

/**
 * The [User] Data Transfer Object is intended to be bound with forms to create [Users][User].
 * The fields are annotated for validation before creating the [User] object from this.
 */
class UserDto {
    /*
    Engineering note: These fields must be initialized as vars and cannot be set as lateinit,
    otherwise Thymeleaf cannot attach to them. It would also be possible to set them in the
    constructor, but it leads to excessively verbose code in other places.
     */

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

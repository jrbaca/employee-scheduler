package com.josephbaca.employeescheduler.controller

import com.josephbaca.employeescheduler.model.Employee
import com.josephbaca.employeescheduler.model.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class EmployeeRestController {

    @Autowired
    private val repository: EmployeeRepository? = null

    @GetMapping("/employee")
    fun customer(model: Model): List<Employee> {
        repository!!.save(Employee("Jon", "Kerbin"))
        return repository.findAllByFirstName("Jon")
    }
}
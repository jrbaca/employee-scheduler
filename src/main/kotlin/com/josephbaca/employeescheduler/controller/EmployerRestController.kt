package com.josephbaca.employeescheduler.controller

import com.josephbaca.employeescheduler.model.Employer
import com.josephbaca.employeescheduler.model.EmployerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
class EmployerRestController {

    @Autowired
    private val repository: EmployerRepository? = null

    @GetMapping("/employers")
    fun all(): List<Employer> {
        return repository!!.findAll();
    }

    @PostMapping("/employers")
    fun newEmployer(@RequestBody newEmployer: Employer): Employer {
        return repository!!.save(newEmployer)
    }

    @GetMapping("/employers/{id}")
    fun getEmployer(@PathVariable id: String): Employer {
        return repository!!.findById(id).orElseThrow { RuntimeException("Employer not found!") }
    }

    @DeleteMapping("/employers/{id}")
    fun deleteEmployer(@PathVariable id: String) {
        repository!!.deleteById(id)
    }
}
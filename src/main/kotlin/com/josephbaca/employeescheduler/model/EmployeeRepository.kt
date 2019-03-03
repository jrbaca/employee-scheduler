package com.josephbaca.employeescheduler.model

import org.springframework.data.mongodb.repository.MongoRepository

interface EmployeeRepository : MongoRepository<Employee, String> {

    fun findAllByFirstName(firstName: String): List<Employee>
}
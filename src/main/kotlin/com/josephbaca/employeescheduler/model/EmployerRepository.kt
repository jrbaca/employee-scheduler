package com.josephbaca.employeescheduler.model

import org.springframework.data.mongodb.repository.MongoRepository

interface EmployerRepository : MongoRepository<Employer, String> {

}
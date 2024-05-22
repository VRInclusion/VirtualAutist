package com.autism.vr.configurations.persisntanses.db.repositories

import com.autism.vr.configurations.persisntanses.db.entities.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface StudentRepository : JpaRepository<Student, UUID> {
    fun findByCode(code: String) : Optional<Student>
}
package com.autism.vr.configurations.persisntanses.db.repositories

import com.autism.vr.configurations.persisntanses.db.entities.Result
import com.autism.vr.configurations.persisntanses.db.entities.TeachSession
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ResultRepository : JpaRepository<Result, UUID> {
    fun deleteAllByTeachSession(teachSession: TeachSession)

    fun findAllByTeachSession(teachSession: TeachSession): List<Result>

}
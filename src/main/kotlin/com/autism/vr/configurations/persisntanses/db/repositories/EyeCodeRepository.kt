package com.autism.vr.configurations.persisntanses.db.repositories

import com.autism.vr.configurations.persisntanses.db.entities.EyeCode
import com.autism.vr.configurations.persisntanses.db.entities.TeachSession
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface EyeCodeRepository : JpaRepository<EyeCode, UUID> {

    fun deleteAllByTeachSession(teachSession: TeachSession)
    fun findAllByTeachSession_Id(teachSessionId: UUID): List<EyeCode>

}
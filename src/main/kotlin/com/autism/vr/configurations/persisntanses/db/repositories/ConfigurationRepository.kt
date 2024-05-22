package com.autism.vr.configurations.persisntanses.db.repositories

import com.autism.vr.configurations.persisntanses.db.entities.TeachSession
import com.autism.vr.configurations.persisntanses.db.entities.config.Configuration
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ConfigurationRepository : JpaRepository<Configuration, UUID> {
    fun deleteAllByTeachSession(teachSession: TeachSession)
    fun findAllByTeachSession_Id(teachSessionId: UUID) : List<Configuration>
}
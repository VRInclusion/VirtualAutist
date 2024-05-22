package com.autism.vr.configurations.persisntanses.db.repositories

import com.autism.vr.configurations.persisntanses.db.entities.Scene
import com.autism.vr.configurations.persisntanses.db.entities.TeachSession
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SceneRepository : JpaRepository<Scene, UUID> {
    fun deleteAllByTeachSession(teachSession: TeachSession)
    fun findAllByTeachSession_Id(teachSessionId: UUID): List<Scene>
}
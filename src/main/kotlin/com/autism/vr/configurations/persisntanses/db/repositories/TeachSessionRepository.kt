package com.autism.vr.configurations.persisntanses.db.repositories

import com.autism.vr.configurations.persisntanses.db.entities.TeachSession
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TeachSessionRepository : JpaRepository<TeachSession, UUID> {
    fun findAllByCode(code: String) : List<TeachSession>
}
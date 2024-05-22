package com.autism.vr.configurations.service.`in`

import com.autism.vr.configurations.persisntanses.db.entities.TeachSession
import com.autism.vr.configurations.persisntanses.db.repositories.TeachSessionRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class InSessionService(
    private val repository: TeachSessionRepository
) {
    fun createSession(): TeachSession {
        return repository.save(TeachSession())
    }

    fun getSessionById(id: UUID): TeachSession {
        return repository.findById(id).orElseThrow()
    }

    fun setCode(teachSession: TeachSession, code: String) {
        teachSession.code = code
        repository.save(teachSession)
    }
}
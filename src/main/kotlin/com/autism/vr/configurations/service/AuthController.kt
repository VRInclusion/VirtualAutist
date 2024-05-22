package com.autism.vr.configurations.service

import com.autism.vr.configurations.persisntanses.db.repositories.ResultRepository
import com.autism.vr.configurations.persisntanses.db.repositories.StudentRepository
import com.autism.vr.configurations.persisntanses.db.repositories.TeachSessionRepository
import com.autism.vr.configurations.persisntanses.dto.StudentDto
import com.autism.vr.configurations.persisntanses.dto.out.OutChildCode
import com.autism.vr.configurations.persisntanses.dto.toDto
import com.autism.vr.configurations.websockets.ConfigWebSocketManager
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthController(
    val teachSessionRepository: TeachSessionRepository,
    val studentRepository: StudentRepository,
    val resultRepository: ResultRepository,
    val configWebSocketManager: ConfigWebSocketManager
) {

    fun checkCode(code: String): UUID? {
        val sessions = teachSessionRepository
            .findAllByCode(code)
            .maxByOrNull { it.updatedAt }
            ?: return null

        return sessions.id
    }

    fun addNewChild(teachSessionId: UUID, child: StudentDto): StudentDto? {
        val entity = child.toEntity()

        val teachSession = teachSessionRepository.findById(teachSessionId).orElse(null) ?: return null
        teachSession.student = studentRepository.save(entity)
        teachSessionRepository.save(teachSession)

        // TODO: fix null safety problems
        val createdChild = teachSession.student!!.toDto()

        configWebSocketManager.sendRequest(teachSessionId, OutChildCode.from(createdChild))
        return createdChild
    }

    fun addExistingChild(teachSessionId: UUID, childId: String) {
        val teachSession = teachSessionRepository.findById(teachSessionId).orElse(null) ?: return

        val child = studentRepository.findByCode(childId).orElse(null) ?: return

        configWebSocketManager.sendRequest(teachSessionId, OutChildCode.from(child.toDto()))
        teachSession.student = child
        teachSessionRepository.save(teachSession)
    }

    fun getResult(id: UUID): List<Unit>? {
        val teachSession = teachSessionRepository.findById(id).orElse(null) ?: return null
        return resultRepository.findAllByTeachSession(teachSession).map { it.toDto() }
    }
}
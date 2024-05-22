package com.autism.vr.configurations.service.`in`

import com.autism.vr.configurations.persisntanses.db.entities.TeachSession
import com.autism.vr.configurations.persisntanses.db.repositories.ResultRepository
import com.autism.vr.configurations.persisntanses.dto.ResultDto
import org.springframework.stereotype.Service

@Service
class InResultService(
    val resultRepository: ResultRepository
) {
    fun setResult(teachSession: TeachSession, result: ResultDto) {
        resultRepository.deleteAllByTeachSession(teachSession)
        resultRepository.save(result.toEntity(teachSession))
    }
}
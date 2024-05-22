package com.autism.vr.configurations.service.`in`

import com.autism.vr.configurations.persisntanses.db.entities.TeachSession
import com.autism.vr.configurations.persisntanses.db.repositories.EyeCodeRepository
import com.autism.vr.configurations.persisntanses.dto.EyeCodeDto
import org.springframework.stereotype.Service

@Service
class InEyeCodeService(
    val inEyeCodeRepository: EyeCodeRepository
) {

    fun addEyeCodes(teachSession: TeachSession, codes: List<EyeCodeDto>) {
        inEyeCodeRepository.deleteAllByTeachSession(teachSession)
        inEyeCodeRepository.saveAll(codes.map { it.toEntity(teachSession) })
    }

}
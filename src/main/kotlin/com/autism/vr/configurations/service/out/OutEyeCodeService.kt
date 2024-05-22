package com.autism.vr.configurations.service.out

import com.autism.vr.configurations.persisntanses.OutCommandsType
import com.autism.vr.configurations.persisntanses.db.repositories.EyeCodeRepository
import com.autism.vr.configurations.persisntanses.dto.EyeCodeDto
import com.autism.vr.configurations.persisntanses.dto.EyeCodeListDto
import com.autism.vr.configurations.persisntanses.dto.out.OutBaseDto
import com.autism.vr.configurations.persisntanses.dto.out.OutEyeCodeDto
import com.autism.vr.configurations.persisntanses.dto.toDto
import com.autism.vr.configurations.service.sendRequest
import com.autism.vr.configurations.websockets.ConfigWebSocketManager
import org.springframework.stereotype.Service
import java.util.*

@Service
class OutEyeCodeService(
    val eyeCodeRepository: EyeCodeRepository,
    val configWebSocketManager: ConfigWebSocketManager
) {

    fun getCodes(teachSessionId: UUID, reading: Boolean): EyeCodeListDto {
        configWebSocketManager.sendRequest(
            teachSessionId,
            OutBaseDto(if (reading) OutCommandsType.GET_EYE_CODES_READIND else OutCommandsType.GET_EYE_CODES)
        )
        return eyeCodeRepository.findAllByTeachSession_Id(teachSessionId)
            .map { it.toDto() }
            .let { EyeCodeListDto(it) }
    }

    fun setCodes(teachSessionId: UUID, code: EyeCodeDto) {
        configWebSocketManager.sendRequest(teachSessionId, OutEyeCodeDto(code))
    }

}
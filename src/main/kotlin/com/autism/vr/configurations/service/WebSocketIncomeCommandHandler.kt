package com.autism.vr.configurations.service

import com.autism.vr.configurations.persisntanses.InCommandsType
import com.autism.vr.configurations.persisntanses.db.entities.TeachSession
import com.autism.vr.configurations.persisntanses.dto.ConfigurationsListDTO
import com.autism.vr.configurations.persisntanses.dto.EyeCodeListDto
import com.autism.vr.configurations.persisntanses.dto.ResultDto
import com.autism.vr.configurations.persisntanses.dto.ScenesListDto
import com.autism.vr.configurations.persisntanses.dto.`in`.*
import com.autism.vr.configurations.websockets.ConfigWebSocketManager


internal fun ConfigWebSocketManager.handleRequest(message: InBaseDto, teachSession: TeachSession) {
    when (message.commandType) {
        InCommandsType.SCENES -> scenesHandler(teachSession, (message as InDtoScenes).value)
        InCommandsType.CONFIGURATIONS -> resultHandler(teachSession, (message as InDtoConfigurations).value)
        InCommandsType.RESULTS -> resultHandler(teachSession, (message as InDtoResults).value)
        InCommandsType.CODE -> setCode(teachSession, (message as InCodeDto).value)
        InCommandsType.EYE_CODES -> eyeCodeHandler(teachSession, (message as InEyeCodesDto).value)
    }
}

private fun ConfigWebSocketManager.scenesHandler(teachSession: TeachSession, scenes: ScenesListDto) {
    inSceneService.setScenes(teachSession, scenes.scenes)
}

private fun ConfigWebSocketManager.eyeCodeHandler(teachSession: TeachSession, codes: EyeCodeListDto) {
    inEyeCodeService.addEyeCodes(teachSession, codes.eyeCodes)
}

private fun ConfigWebSocketManager.setCode(teachSession: TeachSession, code: String) {
    teachInSessionService.setCode(teachSession, code)
}

// TODO: Rename to configuration handler
private fun ConfigWebSocketManager.resultHandler(teachSession: TeachSession, configurations: ConfigurationsListDTO) {
    configService.setConfigurations(teachSession, configurations.configurations)
}

private fun ConfigWebSocketManager.resultHandler(teachSession: TeachSession, result: ResultDto) {
    inResultService.setResult(teachSession, result)
}
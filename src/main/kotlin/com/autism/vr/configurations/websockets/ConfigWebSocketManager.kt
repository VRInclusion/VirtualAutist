package com.autism.vr.configurations.websockets

import com.autism.vr.configurations.persisntanses.InCommandsType
import com.autism.vr.configurations.persisntanses.dto.`in`.*
import com.autism.vr.configurations.service.handleRequest
import com.autism.vr.configurations.service.`in`.*
import com.google.gson.Gson
import org.springframework.stereotype.Service
import org.springframework.web.socket.WebSocketMessage
import org.springframework.web.socket.WebSocketSession
import java.util.*

@Service
class ConfigWebSocketManager(
    internal val configService: InConfigurationsService,
    internal val inSceneService: InSceneService,
    internal val inResultService: InResultService,
    internal val teachInSessionService: InSessionService,
    internal val inEyeCodeService: InEyeCodeService
) {

    val sessions: MutableMap<UUID, WebSocketSession> = mutableMapOf()

    fun addSession(session: WebSocketSession, id: UUID) {
        sessions[id] = session
    }

    fun getSession(id: UUID): WebSocketSession? {
        return sessions[id]
    }

    private fun getIdBySession(session: WebSocketSession): UUID? {
        return sessions.filterValues { it == session }.keys.firstOrNull()
    }

    fun removeSession(id: UUID) {
        sessions.remove(id)
    }

    fun handleReceivedMessage(session: WebSocketSession, message: WebSocketMessage<*>) {
        val teachSessionId = getIdBySession(session) ?: return
        val teachSession = teachInSessionService.getSessionById(teachSessionId)
        val gson = Gson()
        val messageDto = gson.fromJson(message.payload as String)

        handleRequest(messageDto, teachSession)
    }

    fun Gson.fromJson(jsonString: String): InBaseDto {
        val json = fromJson(jsonString, LinkedHashMap::class.java)
        return when (InCommandsType.valueOf(json["commandType"] as String)) {
            InCommandsType.SCENES -> fromJson(jsonString, InDtoScenes::class.java)
            InCommandsType.CONFIGURATIONS -> fromJson(jsonString, InDtoConfigurations::class.java)
            InCommandsType.RESULTS -> fromJson(jsonString, InDtoResults::class.java)
            InCommandsType.CODE -> fromJson(jsonString, InCodeDto::class.java)
            InCommandsType.EYE_CODES -> fromJson(jsonString, InEyeCodesDto::class.java)
        }
    }

}
package com.autism.vr.configurations.service

import com.autism.vr.configurations.persisntanses.dto.out.OutBaseDto
import com.autism.vr.configurations.websockets.ConfigWebSocketManager
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.web.socket.TextMessage
import java.util.*


fun ConfigWebSocketManager.sendRequest(teachSessionId: UUID, dto: OutBaseDto) {
    val session = getSession(teachSessionId) ?: throw NotFoundException()
    session.sendMessage(TextMessage(dto.toJson()))
}

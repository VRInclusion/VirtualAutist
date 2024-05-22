package com.autism.vr.configurations.websockets

import com.autism.vr.configurations.service.`in`.InSessionService
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.WebSocketMessage
import org.springframework.web.socket.WebSocketSession

class ConfigurationsWebSocketHandler(
    private val manager: ConfigWebSocketManager,
    private val inSessionService: InSessionService,
    ) : WebSocketHandler {

    override fun afterConnectionEstablished(session: WebSocketSession) {
        //val code = session.uri?.query?.split("=")?.get(1) ?: return
        val teachSession = inSessionService.createSession()

        if (teachSession.id == null) {
            session.close()
            return
        }
        manager.addSession(session, teachSession.id!!)
    }

    override fun handleMessage(session: WebSocketSession, message: WebSocketMessage<*>) {
        try {
            manager.handleReceivedMessage(session, message)
        } catch (e: Exception) {
            // TODO: do smth with exception
            print(e)
        }
    }

    override fun handleTransportError(session: WebSocketSession, exception: Throwable) {
        // TODO: do smth with exception
        print(exception)
    }

    override fun afterConnectionClosed(session: WebSocketSession, closeStatus: CloseStatus) {
        // TODO: do smth with closeStatus
        print("closed")
    }

    override fun supportsPartialMessages(): Boolean {
        return false
    }

}
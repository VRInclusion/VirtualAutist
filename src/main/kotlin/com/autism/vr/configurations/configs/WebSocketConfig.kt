package com.autism.vr.configurations.configs

import com.autism.vr.configurations.service.`in`.InSessionService
import com.autism.vr.configurations.websockets.ConfigWebSocketManager
import com.autism.vr.configurations.websockets.ConfigurationsWebSocketHandler
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry

@Configuration
@EnableWebSocket
class WebSocketConfig(
    private val configWebSocketManager: ConfigWebSocketManager,
    private val inSessionService: InSessionService
) : WebSocketConfigurer {

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(
            ConfigurationsWebSocketHandler(configWebSocketManager, inSessionService),
            "/ws"
        )
    }

}
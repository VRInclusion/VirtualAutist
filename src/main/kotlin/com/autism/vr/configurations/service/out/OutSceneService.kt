package com.autism.vr.configurations.service.out

import com.autism.vr.configurations.persisntanses.OutCommandsType
import com.autism.vr.configurations.persisntanses.db.repositories.SceneRepository
import com.autism.vr.configurations.persisntanses.dto.SceneDto
import com.autism.vr.configurations.persisntanses.dto.ScenesListDto
import com.autism.vr.configurations.persisntanses.dto.out.OutBaseDto
import com.autism.vr.configurations.persisntanses.dto.out.OutSceneDto
import com.autism.vr.configurations.persisntanses.dto.toDto
import com.autism.vr.configurations.service.sendRequest
import com.autism.vr.configurations.websockets.ConfigWebSocketManager
import org.springframework.stereotype.Service
import java.util.*

@Service
class OutSceneService(
    val sceneRepository: SceneRepository,
    val configWebSocketManager: ConfigWebSocketManager
) {

    fun getScenes(teachSessionId: UUID): ScenesListDto {
        configWebSocketManager.sendRequest(teachSessionId, OutBaseDto(OutCommandsType.GET_SCENES))
        //Thread.sleep(3000)
        return sceneRepository.findAllByTeachSession_Id(teachSessionId)
            .map { it.toDto() }
            .let { ScenesListDto(it) }
    }

    fun setScene(teachSessionId: UUID, scene: SceneDto) {
        configWebSocketManager.sendRequest(teachSessionId, OutSceneDto(scene))
    }

}
package com.autism.vr.configurations.service.`in`

import com.autism.vr.configurations.persisntanses.db.entities.TeachSession
import com.autism.vr.configurations.persisntanses.db.repositories.SceneRepository
import com.autism.vr.configurations.persisntanses.dto.SceneDto
import org.springframework.stereotype.Service

@Service
class InSceneService(
    val sceneRepository: SceneRepository
) {
    fun setScenes(teachSession: TeachSession, scenes: List<SceneDto>) {
        sceneRepository.deleteAllByTeachSession(teachSession)
        sceneRepository.saveAll(scenes.map { it.toEntity(teachSession) })
    }
}
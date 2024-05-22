package com.autism.vr.configurations.persisntanses.dto

import com.autism.vr.configurations.persisntanses.db.entities.Scene
import com.autism.vr.configurations.persisntanses.db.entities.TeachSession

data class ScenesListDto(
    var scenes: List<SceneDto>
)

data class SceneDto (
    var id: Long,
    var name: String?,
) {
    fun toEntity(teachSession: TeachSession): Scene {
        return Scene(
            name = name,
            localId = id,
            teachSession = teachSession,
        )
    }
}


inline fun Scene.toDto(): SceneDto {
    return SceneDto(
        id = this.localId,
        name = this.name,
    )
}

package com.autism.vr.configurations.persisntanses.dto.out

import com.autism.vr.configurations.persisntanses.OutCommandsType
import com.autism.vr.configurations.persisntanses.dto.SceneDto

class OutSceneDto(
    value: SceneDto
) : OutBaseDto(
    commandType = OutCommandsType.SET_SCENE,
    value = value
)
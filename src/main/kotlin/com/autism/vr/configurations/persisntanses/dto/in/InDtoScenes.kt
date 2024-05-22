package com.autism.vr.configurations.persisntanses.dto.`in`

import com.autism.vr.configurations.persisntanses.InCommandsType
import com.autism.vr.configurations.persisntanses.dto.ScenesListDto

class InDtoScenes(
    val value: ScenesListDto
) : InBaseDto(InCommandsType.SCENES)
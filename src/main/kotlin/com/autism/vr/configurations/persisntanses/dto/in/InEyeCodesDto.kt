package com.autism.vr.configurations.persisntanses.dto.`in`

import com.autism.vr.configurations.persisntanses.InCommandsType
import com.autism.vr.configurations.persisntanses.dto.EyeCodeListDto

class InEyeCodesDto(
    val value: EyeCodeListDto
) : InBaseDto(InCommandsType.EYE_CODES)
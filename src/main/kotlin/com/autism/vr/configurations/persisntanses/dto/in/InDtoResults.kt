package com.autism.vr.configurations.persisntanses.dto.`in`

import com.autism.vr.configurations.persisntanses.InCommandsType
import com.autism.vr.configurations.persisntanses.dto.ResultDto

class InDtoResults(
    val value: ResultDto
) : InBaseDto(
    InCommandsType.RESULTS
)
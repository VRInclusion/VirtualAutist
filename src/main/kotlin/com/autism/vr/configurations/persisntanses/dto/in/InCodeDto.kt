package com.autism.vr.configurations.persisntanses.dto.`in`

import com.autism.vr.configurations.persisntanses.InCommandsType

class InCodeDto(
    val value: String
) : InBaseDto(
    InCommandsType.CODE
)
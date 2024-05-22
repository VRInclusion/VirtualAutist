package com.autism.vr.configurations.persisntanses.dto.`in`

import com.autism.vr.configurations.persisntanses.InCommandsType
import com.autism.vr.configurations.persisntanses.dto.ConfigurationsListDTO

class InDtoConfigurations(
    val value: ConfigurationsListDTO
) : InBaseDto(InCommandsType.CONFIGURATIONS)
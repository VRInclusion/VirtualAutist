package com.autism.vr.configurations.persisntanses.dto.out

import com.autism.vr.configurations.persisntanses.OutCommandsType
import com.autism.vr.configurations.persisntanses.dto.ConfigurationDTO

class OutConfigurationDto(
    value: ConfigurationDTO
) : OutBaseDto(
    commandType = OutCommandsType.SET_CONFIGURATION,
    value = value
)
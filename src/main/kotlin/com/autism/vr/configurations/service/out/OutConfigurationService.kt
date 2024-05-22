package com.autism.vr.configurations.service.out

import com.autism.vr.configurations.persisntanses.OutCommandsType
import com.autism.vr.configurations.persisntanses.db.repositories.ConfigurationRepository
import com.autism.vr.configurations.persisntanses.dto.ConfigurationDTO
import com.autism.vr.configurations.persisntanses.dto.ConfigurationsListDTO
import com.autism.vr.configurations.persisntanses.dto.out.OutBaseDto
import com.autism.vr.configurations.persisntanses.dto.out.OutConfigurationDto
import com.autism.vr.configurations.persisntanses.dto.toDto
import com.autism.vr.configurations.service.sendRequest
import com.autism.vr.configurations.websockets.ConfigWebSocketManager
import org.springframework.stereotype.Service
import java.util.*

@Service
class OutConfigurationService(
    val configWebSocketManager: ConfigWebSocketManager,
    val configurationRepository: ConfigurationRepository
) {

    fun getConfigurations(teachSessionId: UUID): ConfigurationsListDTO {
        configWebSocketManager.sendRequest(teachSessionId, OutBaseDto(OutCommandsType.GET_CONFIGURATIONS))
        return configurationRepository.findAllByTeachSession_Id(teachSessionId)
            .map { it.toDto() }
            .let { ConfigurationsListDTO(it) }
    }

    fun changeConfiguration(teachSessionId: UUID, dto: ConfigurationDTO) {
        val configuration = configurationRepository.findById(dto.id ?: return).get()
        configuration.change(dto)
        configurationRepository.save(configuration)
        configWebSocketManager.sendRequest(teachSessionId, OutConfigurationDto(dto))
    }

}
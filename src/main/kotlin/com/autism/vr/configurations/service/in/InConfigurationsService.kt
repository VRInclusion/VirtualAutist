package com.autism.vr.configurations.service.`in`

import com.autism.vr.configurations.persisntanses.db.entities.TeachSession
import com.autism.vr.configurations.persisntanses.db.repositories.ConfigurationRepository
import com.autism.vr.configurations.persisntanses.dto.ConfigurationDTO
import com.autism.vr.configurations.persisntanses.dto.toEntity
import org.springframework.stereotype.Service

@Service
class InConfigurationsService(
    val configurationsRepository: ConfigurationRepository
) {
    fun setConfigurations(teachSession: TeachSession, configurations: List<ConfigurationDTO>) {
        configurationsRepository.deleteAllByTeachSession(teachSession)
        configurationsRepository.saveAll(configurations.map { it.toEntity(teachSession) })
    }

}
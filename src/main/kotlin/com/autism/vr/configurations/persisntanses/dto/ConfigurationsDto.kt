package com.autism.vr.configurations.persisntanses.dto

import com.autism.vr.configurations.persisntanses.db.entities.TeachSession
import com.autism.vr.configurations.persisntanses.db.entities.config.Configuration
import com.autism.vr.configurations.persisntanses.db.entities.config.ConfigurationType
import com.autism.vr.configurations.persisntanses.db.entities.config.IntegerConfig
import com.autism.vr.configurations.persisntanses.db.entities.config.SwitchConfig
import java.util.*

data class ConfigurationsListDTO(
    val configurations: List<ConfigurationDTO>
)

data class ConfigurationDTO(
    val id: UUID?,
    val name: String?,
    val description: String?,
    val type: ConfigurationType?,
    val switchConfig: SwitchConfigDTO?,
    val intConfig: IntegerConfigDTO?
)


data class SwitchConfigDTO(
    val defaultValue: Boolean?,
    val value: Boolean?
)

data class IntegerConfigDTO(
    val defaultValue: Int?,
    val value: Int?,
)

fun ConfigurationDTO.toEntity(teachSession: TeachSession): Configuration {
    return when (type) {
        ConfigurationType.SWITCH -> {
            switchConfig ?: throw IllegalArgumentException("SwitchConfig is required")
            SwitchConfig(
                teachSession = teachSession,
                name = name ?: throw IllegalArgumentException("Name is required"),
                description = description ?: "",
                defaultValue = switchConfig.defaultValue ?: false,
                value = switchConfig.value ?: false
            )
        }

        ConfigurationType.INT -> {
            intConfig ?: throw IllegalArgumentException("IntConfig is required")
            IntegerConfig(
                teachSession = teachSession,
                description = this.description ?: "",
                name = name ?: throw IllegalArgumentException("Name is required"),
                defaultValue = intConfig.defaultValue ?: 0,
                value = intConfig.value ?: 0,
            )
        }

        else -> throw IllegalArgumentException("Configuration type is required")
    }
}

fun Configuration.toDto(): ConfigurationDTO {
    return when (type) {
        ConfigurationType.SWITCH -> {
            val switchConfig = this as SwitchConfig
            ConfigurationDTO(
                name = name,
                description = description,
                type = type,
                switchConfig = SwitchConfigDTO(
                    defaultValue = switchConfig.defaultValue,
                    value = switchConfig.value
                ),
                intConfig = null,
                id = id
            )
        }

        ConfigurationType.INT -> {
            val intConfig = this as IntegerConfig
            ConfigurationDTO(
                name = name,
                description = description,
                type = type,
                switchConfig = null,
                intConfig = IntegerConfigDTO(
                    defaultValue = intConfig.defaultValue,
                    value = intConfig.value
                ),
                id = id
            )
        }

        else -> throw IllegalArgumentException("Configuration type is required")
    }
}
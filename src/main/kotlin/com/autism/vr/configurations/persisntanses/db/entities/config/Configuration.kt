package com.autism.vr.configurations.persisntanses.db.entities.config

import com.autism.vr.configurations.persisntanses.db.entities.TeachSession
import com.autism.vr.configurations.persisntanses.dto.ConfigurationDTO
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "configurations", schema = "autism_vr")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
abstract class Configuration(

    @ManyToOne(fetch = FetchType.LAZY)
    open var teachSession: TeachSession? = null,

    open var name: String? = null,

    open var description: String? = null,

    @Enumerated(EnumType.STRING)
    @Column(insertable = false, updatable = false)
    open var type: ConfigurationType = ConfigurationType.NONE

) {
    fun change(dto: ConfigurationDTO) {
        name = dto.name
        description = dto.description
        when (type) {
            ConfigurationType.SWITCH -> {
                if (this is SwitchConfig) {
                    this.value = dto.switchConfig?.value ?: throw IllegalArgumentException("SwitchConfig is required")
                    this.defaultValue =
                        dto.switchConfig.defaultValue ?: throw IllegalArgumentException("SwitchConfig is required")
                }
            }

            ConfigurationType.INT -> {
                val intConfig = dto.intConfig ?: throw IllegalArgumentException("IntConfig is required")
                if (this is IntegerConfig) {
                    this.value = intConfig.value ?: throw IllegalArgumentException("IntConfig is required")
                    this.defaultValue =
                        intConfig.defaultValue ?: throw IllegalArgumentException("IntConfig is required")
                }
            }

            else -> throw IllegalArgumentException("Configuration type is required")
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id: UUID? = null
}

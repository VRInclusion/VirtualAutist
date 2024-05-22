package com.autism.vr.configurations.persisntanses.db.entities.config

import com.autism.vr.configurations.persisntanses.db.entities.TeachSession
import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import java.util.*

@Entity
@DiscriminatorValue("SWITCH")
class SwitchConfig(

    teachSession: TeachSession? = null,

    name: String = "",

    description: String = "",

    @Column(name = "default_value_bool")
    open var defaultValue: Boolean = false,

    @Column(name = "value_bool")
    open var value: Boolean = defaultValue

) : Configuration(teachSession, name, description, ConfigurationType.SWITCH)

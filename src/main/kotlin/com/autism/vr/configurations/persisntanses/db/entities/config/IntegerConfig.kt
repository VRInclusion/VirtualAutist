package com.autism.vr.configurations.persisntanses.db.entities.config

import com.autism.vr.configurations.persisntanses.db.entities.TeachSession
import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity


@Entity
@DiscriminatorValue("INT")
class IntegerConfig(

    teachSession: TeachSession? = null,

    name: String = "",

    description: String = "",

    @Column(name = "default_value_int")
    open var defaultValue: Int = 0,

    @Column(name = "value_int")
    open var value: Int = defaultValue,

) : Configuration(teachSession, name, description, ConfigurationType.INT)
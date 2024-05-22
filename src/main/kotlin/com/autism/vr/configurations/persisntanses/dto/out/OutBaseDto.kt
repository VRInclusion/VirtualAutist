package com.autism.vr.configurations.persisntanses.dto.out

import com.autism.vr.configurations.persisntanses.OutCommandsType
import com.google.gson.Gson

open class OutBaseDto(
    val commandType: OutCommandsType,
    val value: Any? = null
) {
    fun toJson(): String {
        val gson = Gson()
        return when (commandType) {
            OutCommandsType.SET_SCENE -> gson.toJson(this as OutSceneDto)
            OutCommandsType.SET_CONFIGURATION -> gson.toJson(this as OutConfigurationDto)
            OutCommandsType.SET_EYE_CODE -> gson.toJson(this as OutEyeCodeDto)
            OutCommandsType.CHILD_CODE -> gson.toJson(this as OutChildCode)
            else -> gson.toJson(this)
        }
    }
}
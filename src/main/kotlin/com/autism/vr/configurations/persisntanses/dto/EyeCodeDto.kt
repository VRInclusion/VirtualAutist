package com.autism.vr.configurations.persisntanses.dto

import com.autism.vr.configurations.persisntanses.db.entities.EyeCode
import com.autism.vr.configurations.persisntanses.db.entities.TeachSession


data class EyeCodeListDto(
    val eyeCodes: List<EyeCodeDto>
)

data class EyeCodeDto(
    val id: String,
    val answer: String,
) {
    fun toEntity(teachSession: TeachSession): EyeCode {
        return EyeCode(
            localId = id,
            answer = answer,
            teachSession = teachSession
        )
    }
}

fun EyeCode.toDto(): EyeCodeDto {
    return EyeCodeDto(
        id = localId,
        answer = answer
    )
}
package com.autism.vr.configurations.persisntanses.dto

import com.autism.vr.configurations.persisntanses.db.entities.Result
import com.autism.vr.configurations.persisntanses.db.entities.TeachSession

data class ResultDto(
    var result: String,
) {
    fun toEntity(teachSession: TeachSession): Result {
        return Result(
            results = result,
            teachSession = teachSession,
        )
    }
}

fun Result.toDto(): ResultDto {
    return ResultDto(
        result = results ?: "",
    )
}
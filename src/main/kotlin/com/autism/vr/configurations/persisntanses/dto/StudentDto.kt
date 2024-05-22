package com.autism.vr.configurations.persisntanses.dto

import com.autism.vr.configurations.helpers.random
import com.autism.vr.configurations.persisntanses.db.entities.Student

class StudentDto(
    val code: String?,
    var name: String?
) {
    fun toEntity(): Student {
        return Student(
            name = name,
            code = code ?: String.random(5)
        )
    }
}

fun Student.toDto(): StudentDto {
    return StudentDto(
        code = code,
        name = name
    )
}
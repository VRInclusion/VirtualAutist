package com.autism.vr.configurations.persisntanses.dto.out

import com.autism.vr.configurations.persisntanses.OutCommandsType
import com.autism.vr.configurations.persisntanses.dto.StudentDto

class OutChildCode(
    code: String,
    name: String
) : OutBaseDto(OutCommandsType.CHILD_CODE, StudentDto(code, name)) {
    companion object {
        fun from(student: StudentDto): OutChildCode {
            return OutChildCode(student.code ?: "", student.name ?: "")
        }
    }
}

package com.autism.vr.configurations.persisntanses.dto.out

import com.autism.vr.configurations.persisntanses.OutCommandsType
import com.autism.vr.configurations.persisntanses.dto.EyeCodeDto

class OutEyeCodeDto(
    value: EyeCodeDto
) : OutBaseDto(OutCommandsType.SET_EYE_CODE, value) {


}
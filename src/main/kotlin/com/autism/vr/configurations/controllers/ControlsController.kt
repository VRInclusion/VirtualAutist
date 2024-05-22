package com.autism.vr.configurations.controllers

import com.autism.vr.configurations.persisntanses.dto.*
import com.autism.vr.configurations.service.out.OutConfigurationService
import com.autism.vr.configurations.service.out.OutEyeCodeService
import com.autism.vr.configurations.service.out.OutSceneService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/controls")
class ControlsController(
    val outSceneService: OutSceneService,
    val outConfigurationService: OutConfigurationService,
    val eyeCodeService: OutEyeCodeService
) {

    @RequestMapping(value = ["/getEyeCodes/{id}"], method = [RequestMethod.GET], produces = ["application/json; charset=utf-8"])
    fun getEyeCodes(@PathVariable id: UUID, @RequestParam reading: Boolean): ResponseEntity<EyeCodeListDto> {
        val response =  ResponseEntity.ok(eyeCodeService.getCodes(id, reading))
//        response.headers.acceptCharset = listOf(Charsets.UTF_8)
        return response
    }

    @PostMapping("/setEyeCode/{id}")
    fun setEyeCode(@PathVariable id: UUID, @RequestBody eyeCode: EyeCodeDto): ResponseEntity<Any> {
        eyeCodeService.setCodes(id, eyeCode)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/getScenes/{id}")
    fun getScenes(@PathVariable id: UUID): ResponseEntity<ScenesListDto> {
        return ResponseEntity.ok(outSceneService.getScenes(id))
    }

    @PostMapping("/setScene/{id}")
    fun setScene(@PathVariable id: UUID, @RequestBody sceneDto: SceneDto): ResponseEntity<Any> {
        outSceneService.setScene(id, sceneDto)
        return ResponseEntity.ok().build()
    }

    @RequestMapping(value=["/getConfiguration/{id}"], method = [RequestMethod.GET], produces = ["application/json; charset=utf-8"])
    fun getConfiguration(@PathVariable id: UUID): ResponseEntity<ConfigurationsListDTO> {
        return ResponseEntity.ok(outConfigurationService.getConfigurations(id))
    }

    @PostMapping("/changeConfiguration/{id}")
    fun changeConfiguration(
        @PathVariable id: UUID,
        @RequestBody configurationDTO: ConfigurationDTO
    ): ResponseEntity<Any> {
        outConfigurationService.changeConfiguration(id, configurationDTO)
        return ResponseEntity.ok().build()
    }

}
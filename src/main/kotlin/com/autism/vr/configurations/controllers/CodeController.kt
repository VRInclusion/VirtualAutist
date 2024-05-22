package com.autism.vr.configurations.controllers

import com.autism.vr.configurations.persisntanses.dto.StudentDto
import com.autism.vr.configurations.persisntanses.dto.out.CodeOutDto
import com.autism.vr.configurations.service.AuthController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/code")
class CodeController(
    val authController: AuthController
) {

    @GetMapping("code/{code}")
    fun checkCode(@PathVariable code: String): ResponseEntity<CodeOutDto> {
        authController.checkCode(code).let {
            when (it) {
                null -> return ResponseEntity.badRequest().build()
                else -> return ResponseEntity.ok(CodeOutDto(it, code))
            }
        }
    }

    @PostMapping("new-child/{id}")
    fun addNewChild(@PathVariable id: UUID, @RequestBody child: StudentDto): ResponseEntity<StudentDto> {
        print("addNewChild: $id, $child")
        return ResponseEntity.ok(authController.addNewChild(id, child))
    }

    @GetMapping("child/{id}")
    fun addExistingChild(@PathVariable id: UUID, @RequestParam code: String): ResponseEntity<Any> {
        print("addExistingChild: $id, $code")
        authController.addExistingChild(id, code)
        return ResponseEntity.ok().build()
    }

    @GetMapping("result/{id}")
    fun getResult(@PathVariable id: UUID): ResponseEntity<Any> {
        print("getResult: $id")
        return authController.getResult(id)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.badRequest().build()
    }

}
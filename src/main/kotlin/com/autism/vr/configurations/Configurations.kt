package com.autism.vr.configurations

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.autism.vr.configurations"])
class Configurations

fun main(args: Array<String>) {
    runApplication<Configurations>(*args)
}
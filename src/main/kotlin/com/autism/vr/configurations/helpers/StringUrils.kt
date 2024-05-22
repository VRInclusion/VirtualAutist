package com.autism.vr.configurations.helpers

fun String.Companion.random(len: Int): String {
    val allowedChars = '1'..'9'
    print(allowedChars)
    return (1..len)
        .map { allowedChars.random() }
        .joinToString("")

}
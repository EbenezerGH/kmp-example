package com.example

expect fun platformName(): String

fun createApplicationScreenMessage(): String {
    return "Kotlin Rocks on ${platformName()}"
}

expect fun String.dateFormatToMilliseconds(format: String): Long
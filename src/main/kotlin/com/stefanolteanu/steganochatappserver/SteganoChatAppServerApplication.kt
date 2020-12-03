package com.stefanolteanu.steganochatappserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SteganoChatAppServerApplication

fun main(args: Array<String>) {
    runApplication<SteganoChatAppServerApplication>(*args)
}

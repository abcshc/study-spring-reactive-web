package com.example.studyspringreactiveweb

import com.example.studyspringreactiveweb.websocket.client.cryptowatch.CryptowatchClient
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StudySpringReactiveWebApplication

fun main(args: Array<String>) {
    runApplication<StudySpringReactiveWebApplication>(*args)
    CryptowatchClient().execute()
}

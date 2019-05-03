package com.example.studyspringreactiveweb.websocket.client.cryptowatch

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.HandlerMapping
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping
import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.web.reactive.socket.WebSocketMessage
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient
import reactor.core.publisher.Mono
import java.net.URI
import java.time.Duration
import java.util.*


class CryptowatchClient(@Qualifier("cryptowatchWebSocketHandler") val webSocketHandler: WebSocketHandler) {
    private val cryptowatchClient = ReactorNettyWebSocketClient()

    fun execute() {
        cryptowatchClient.execute(
                URI.create("wss://stream.cryptowat.ch")
        ) { session ->
            session.send(
                    Mono.just(session.textMessage("event-spring-reactive-client-websocket")))
                    .thenMany(session.receive()
                            .map(WebSocketMessage::getPayloadAsText)
                            .log())
                    .then()
        }
                .block(Duration.ofSeconds(10L))
    }

    @Bean
    fun webSocketHandlerMapping(): HandlerMapping {
        val map = HashMap<String, WebSocketHandler>()
        map["/event-emitter"] = webSocketHandler

        val handlerMapping = SimpleUrlHandlerMapping()
        handlerMapping.order = 1
        handlerMapping.urlMap = map
        return handlerMapping
    }
}
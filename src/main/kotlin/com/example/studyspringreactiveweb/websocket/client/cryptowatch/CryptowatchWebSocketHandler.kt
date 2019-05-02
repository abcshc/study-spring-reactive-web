package com.example.studyspringreactiveweb.websocket.client.cryptowatch

import org.springframework.stereotype.Component
import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.web.reactive.socket.WebSocketSession
import reactor.core.publisher.Mono

@Component("cryptowatchWebSocketHandler")
class CryptowatchWebSocketHandler : WebSocketHandler {
    override fun handle(session: WebSocketSession): Mono<Void> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
package com.example.studyspringreactiveweb.example

import io.netty.bootstrap.Bootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioSocketChannel


class OnlyNettyExample {
    var bootstrap = Bootstrap()
    fun setBootstrap(address: String) {
        bootstrap.connect()
        val nioEventLoopGroup = NioEventLoopGroup()
        bootstrap.group(nioEventLoopGroup)
        bootstrap.channel(NioSocketChannel::class.java)
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true)
        bootstrap.handler(object : ChannelInitializer<SocketChannel>() {
            public override fun initChannel(ch: SocketChannel) {
                ch.pipeline().addLast()
            }
        })
//        val f = b.connect(host, port).sync()
    }
}
package com.john.netty.client;

import com.john.netty.decoder.TimeDecoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TimeClient {

    public static void main(String[] args) {
        String host = "localhost";
//        int port = Integer.parseInt(args[1]);
        int port = 8888;
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(workGroup)
        .channel(NioSocketChannel.class)
        .option(ChannelOption.SO_KEEPALIVE,true)
        .handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new TimeDecoder(),new TimeClientHandler());
            }
        });

        try {
            ChannelFuture future = b.connect(host, port).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workGroup.shutdownGracefully();
        }

    }
}

package com.john.netty.handler;

import com.john.netty.pojo.UnixTime;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        /*ByteBuf time = ctx.alloc().buffer(4);
        time.writeInt((int) (System.currentTimeMillis() + 1000L + 2208988800L));
        ChannelFuture future = ctx.writeAndFlush(time);
        future.addListener((ChannelFutureListener) channelFuture -> {
            assert future == channelFuture;
            ctx.close();
        });*/
        ChannelFuture future = ctx.writeAndFlush(new UnixTime());
        future.addListener(ChannelFutureListener.CLOSE);
    }
}

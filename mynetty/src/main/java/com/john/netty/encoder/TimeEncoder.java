package com.john.netty.encoder;

import com.john.netty.pojo.UnixTime;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class TimeEncoder extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        UnixTime time = (UnixTime) msg;
        ByteBuf encode = ctx.alloc().buffer(4);
        encode.writeInt((int) time.getValue());
        ctx.write(encode, promise);
    }
}

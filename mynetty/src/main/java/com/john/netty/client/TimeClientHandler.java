package com.john.netty.client;


import com.john.netty.pojo.UnixTime;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

public class TimeClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        /*ByteBuf buf = (ByteBuf) msg;
        try {
            long timestamp = (buf.readUnsignedInt() - 2208988800L) * 1000L;
            System.out.println(new Date(timestamp));
            ctx.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            buf.release();
        }*/

        UnixTime time = (UnixTime) msg;
        System.out.println(time);
        ctx.close();
    }
}

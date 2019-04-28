package com.john.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        try {
//            ByteBuf in = (ByteBuf) msg;
//            while(in.isReadable()){
//                System.out.println(in.readByte());
//                System.out.println(in.toString(io.netty.util.CharsetUtil.US_ASCII));
//                System.out.flush();

//            }
//        } finally {
//            ReferenceCountUtil.release(msg);
//        }
        System.out.println(msg);
        ctx.write(msg); // (1)
        ctx.flush(); // (2)
    }
}

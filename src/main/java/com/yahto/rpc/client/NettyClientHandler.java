package com.yahto.rpc.client;

import com.yahto.rpc.protocol.protobuf.MessageBase;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yahto
 * @date 2020/3/13 2:32 PM
 */
@Slf4j
public class NettyClientHandler extends SimpleChannelInboundHandler<MessageBase.Message> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageBase.Message msg) throws Exception {
        log.info("客户端收到消息：{}", msg.toString());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}

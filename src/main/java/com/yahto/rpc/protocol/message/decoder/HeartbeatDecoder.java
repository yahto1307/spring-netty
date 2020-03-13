package com.yahto.rpc.protocol.message.decoder;

import com.yahto.rpc.protocol.message.HeartbeatRequestPacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author yahto
 * @date 2020/3/13 1:59 PM
 */
@Slf4j
public class HeartbeatDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        byte version = byteBuf.readByte();
        byte command = byteBuf.readByte();
        log.info("version : {}, command : {}", version, command);
        HeartbeatRequestPacket requestPacket = new HeartbeatRequestPacket();
        requestPacket.setVersion(version);
        list.add(requestPacket);
    }
}

package com.yahto.rpc.client;

import com.yahto.rpc.protocol.protobuf.MessageBase;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;
import org.springframework.stereotype.Component;

/**
 * @author yahto
 * @date 2020/3/13 2:47 PM
 */
@Component
public class ClientHandlerInitializer extends ChannelInitializer<Channel> {
    private final HeartbeatHandler heartbeatHandler;

    public ClientHandlerInitializer(HeartbeatHandler heartbeatHandler) {
        this.heartbeatHandler = heartbeatHandler;
    }

    @Override
    protected void initChannel(Channel channel) throws Exception {
        channel.pipeline()
                .addLast(new IdleStateHandler(0, 10, 0))
                .addLast(new ProtobufVarint32FrameDecoder())
                .addLast(new ProtobufDecoder(MessageBase.Message.getDefaultInstance()))
                .addLast(new ProtobufVarint32LengthFieldPrepender())
                .addLast(new ProtobufEncoder())
                .addLast(heartbeatHandler)
                .addLast(new NettyClientHandler());
    }
}

package com.yahto.rpc.util;

import com.yahto.rpc.protocol.protobuf.MessageBase;

import java.util.UUID;

/**
 * @author yahto
 * @date 2020/3/13 2:50 PM
 */
public class MessageBaseTest {
    public static void main(String[] args) {
        MessageBase.Message message = MessageBase.Message.newBuilder()
                .setRequestId(UUID.randomUUID().toString())
                .setContent("hello world").build();
        System.out.println("message: " + message.toString());
    }
}

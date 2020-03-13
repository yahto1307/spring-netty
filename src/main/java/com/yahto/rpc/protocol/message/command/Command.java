package com.yahto.rpc.protocol.message.command;

/**
 * @author yahto
 * @date 2020/3/13 1:58 PM
 */
public interface Command {
    Byte HEARTBEAT_REQUEST = 1;
    Byte HEARTBEAT_RESPONSE = 2;
}

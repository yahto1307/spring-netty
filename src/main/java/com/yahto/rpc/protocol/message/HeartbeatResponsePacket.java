package com.yahto.rpc.protocol.message;


import com.yahto.rpc.protocol.message.command.Command;


/**
 * @author yahto
 * @date 2020/3/13 2:01 PM
 */
public class HeartbeatResponsePacket extends AbstractPacket {
    @Override
    public Byte getCommand() {
        return Command.HEARTBEAT_RESPONSE;
    }
}

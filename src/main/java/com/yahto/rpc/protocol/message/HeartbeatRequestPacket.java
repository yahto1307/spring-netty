package com.yahto.rpc.protocol.message;

import com.yahto.rpc.protocol.message.command.Command;

/**
 * @author yahto
 * @date 2020/3/13 2:04 PM
 */
public class HeartbeatRequestPacket extends AbstractPacket {
    @Override
    public Byte getCommand() {
        return Command.HEARTBEAT_REQUEST;
    }
}

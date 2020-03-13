package com.yahto.rpc.protocol.message;

import lombok.Data;

/**
 * @author yahto
 * @date 2020/3/13 2:02 PM
 */
@Data
public abstract class AbstractPacket {
    private Byte version = 1;

    public abstract Byte getCommand();
}

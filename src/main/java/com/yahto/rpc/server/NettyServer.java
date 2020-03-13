package com.yahto.rpc.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;

/**
 * @author yahto
 * @date 2020/3/13 1:48 PM
 */
@Component
@Slf4j
public class NettyServer {

    /**
     * boss 处理连接线程组
     */
    private EventLoopGroup boss = new NioEventLoopGroup();

    /**
     * work 处理数据线程组
     */
    private EventLoopGroup work = new NioEventLoopGroup();

    @Value("${netty.port}")
    private Integer port;


    @PostConstruct
    public void start() throws InterruptedException {
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss, work)
                .channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress(port))
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childHandler(new NettyServerHandlerInitializer());
        ChannelFuture future = bootstrap.bind().sync();
        if (future.isSuccess()) {
            log.info("netty server start");
        }
    }

    @PreDestroy
    public void destroy() throws InterruptedException {
        boss.shutdownGracefully().sync();
        work.shutdownGracefully().sync();
    }

}

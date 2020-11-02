package rpc.provider;

import rpc.netty.NettyServer;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/23 16:14
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class ServerBootstrap {

    public static void main(String[] args) throws InterruptedException {
        NettyServer.startServer("127.0.0.1",8080);
    }
}
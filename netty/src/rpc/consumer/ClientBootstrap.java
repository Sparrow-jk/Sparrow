package rpc.consumer;

import rpc.netty.NettyClient;
import rpc.publicinterface.HelloService;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/23 17:08
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class ClientBootstrap {

    public static final String providerName = "HelloService#hello#";

    public static void main(String[] args) {

        NettyClient nettyClient = new NettyClient();
        HelloService helloService = (HelloService) nettyClient.getProxy(HelloService.class, providerName);
        String result = helloService.hello("你好 dubbo");

        System.out.println("调用结果：" + result);


    }


}






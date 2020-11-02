package rpc.provider;

import rpc.publicinterface.HelloService;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/23 16:11
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String msg) {
        System.out.println("收到客户端消息：" + msg);
        if (msg != null) {
            return "已收到客户端消息：" + msg;
        }
        return "已收到客户端消息";
    }
}

package provider;

import framework.Protocol;
import framework.URL;
import protocol.http.HttpProtocol;
import protocol.http.HttpServer;
import provider.api.HelloService;
import provider.api.HelloServiceImpl;
import register.RemoteRegister;

import java.util.HashMap;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/9/28 23:26
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class Provider {
    public static void main(String[] args) {

        // 1.本地注册
        LocalRegister.registry(HelloService.class.getName(), HelloServiceImpl.class);

        // 2.远程注册
        URL url = new URL("localhost", 8080);
        RemoteRegister.registry(HelloService.class.getName(), url);

        // 3.启动tomcat
       /* HttpServer httpServer = new HttpServer();
        httpServer.start("localhost", 8080);*/
        Protocol protocol = new HttpProtocol();
        protocol.start(url);

    }
}

package consumer;

import framework.Invocation;
import framework.ProxyFactory;
import protocol.http.HttpClient;
import provider.api.HelloService;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/9/29 0:12
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class Consumer {

    public static void main(String[] args) {

/*        HttpClient httpClient = new HttpClient();
        Invocation invocation = new Invocation(HelloService.class.getName(), "sayHello", new Class[]{String.class}, new Object[]{
                "wengjianmeng"});

        String result = httpClient.send("localhost", 8080, invocation);*/


        HelloService proxy = ProxyFactory.getProxy(HelloService.class);


        System.out.println(proxy.sayHello("翁建孟"));
    }
}

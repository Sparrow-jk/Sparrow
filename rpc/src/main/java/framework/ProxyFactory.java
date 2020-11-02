package framework;

import protocol.http.HttpClient;
import protocol.http.HttpProtocol;
import provider.api.HelloService;
import register.RemoteRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/9/29 1:12
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class ProxyFactory {

    @SuppressWarnings("unchecked")
    public static <T> T getProxy(Class<T> interfaceClass) {

        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, (proxy, method, args) -> {

            Protocol protocol = ProtocolFactory.getProtocol();
            Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), method.getParameterTypes(), args);

            URL url = RemoteRegister.getUrl(interfaceClass.getName());
            return protocol.send(url.getHostname(), url.getPort(), invocation);

        });
    }

}

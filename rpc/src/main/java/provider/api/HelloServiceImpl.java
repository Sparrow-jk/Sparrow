package provider.api;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/9/29 0:48
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String msg) {
        return "hello " + msg;
    }
}

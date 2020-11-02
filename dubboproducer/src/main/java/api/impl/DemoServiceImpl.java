package api.impl;

import api.DemoService;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/10/14 22:12
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}

package testXmlSpring;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/9/13 17:19
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class User {

    private String name;

    public HelloWorldService helloWorldService;

    public void showUser() {
        System.out.println(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}

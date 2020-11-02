package testXmlSpring;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/9/13 17:18
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class HelloWorldService {

    private String name;

    private Integer age;

    public User user;

    public void showHelloWorld() {
        System.out.println(name + ":" + age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

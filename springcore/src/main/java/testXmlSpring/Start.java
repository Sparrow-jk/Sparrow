package testXmlSpring;

import org.springframework.aop.TargetSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/9/13 17:25
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class Start {

//    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
//
//        HelloWorldService helloWorldService = (HelloWorldService) context.getBean("helloWorldService");
//        helloWorldService.showHelloWorld();
//
//        User user = (User) context.getBean("user");
//        user.showUser();
//    }

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        TargetSource targetSource = (TargetSource) context.getBean("targetSource1");
        for (int i = 0; i < 10; i++) {
            Apple apple = (Apple) targetSource.getTarget();
            apple.eat();
        }
    }


}

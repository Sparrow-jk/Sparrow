package aoptest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/9/13 22:35
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class Start {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        Person bean2 = (Person)ac.getBean("student");
        bean2.say();
    }
}

package testSetPropertyValues;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.ResolvableType;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/9/11 15:46
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class Start {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigClass.class);
        System.out.println("The beans in the IOC container are listed as follows: ");
        //1.打印IOC容器中所有的 实例对象名称
        //String[] names = applicationContext.getBeanNamesForType(ResolvableType.forType(TestController.class));
        System.out.println( applicationContext.getBean("testController"));
     /*   for (String name : names) {
            System.out.println(name + " --- " + applicationContext.getBean(name));
        }*/

        ((AnnotationConfigApplicationContext) applicationContext).close();
}
    }
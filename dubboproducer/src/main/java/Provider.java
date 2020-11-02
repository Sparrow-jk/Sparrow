import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/10/14 22:18
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class Provider {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/provider"});
        context.start();
        System.out.println("producer start...........");
        System.in.read(); // 按任意键退出
    }
}

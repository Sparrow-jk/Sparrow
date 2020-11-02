import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(TestFactoryBean.class);
        applicationContext.refresh();
        TestFactoryBean bean = (TestFactoryBean) applicationContext.getBean("&testFactoryBean");
        TestBean testBean = bean.getObject();
        System.out.println(testBean);
    }
}

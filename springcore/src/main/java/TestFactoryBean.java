import org.springframework.beans.factory.FactoryBean;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/9/11 15:40
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */

public class TestFactoryBean implements FactoryBean<TestBean> {
    @Override
    public TestBean getObject() throws Exception {
        return new TestBean();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}

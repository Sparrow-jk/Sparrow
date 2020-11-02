package testXmlSpring;

import org.springframework.aop.TargetSource;

import java.util.concurrent.ThreadLocalRandom;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/9/13 21:29
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class TargetSourceTest implements TargetSource {
    private Apple apple1;
    private Apple apple2;

    public TargetSourceTest() {
        this.apple1 = new Apple(1);
        this.apple2 = new Apple(2);
    }

    @Override
    public Class<?> getTargetClass() {
        return Apple.class;
    }

    @Override
    public boolean isStatic() {
        return false;
    }

    @Override
    public Object getTarget() throws Exception {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int index = random.nextInt(2);
        return index % 2 == 0 ? apple1 : apple2;
    }

    @Override
    public void releaseTarget(Object target) throws Exception {}

}

package testSetPropertyValues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/9/13 16:48
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
@Component
@Lazy
public class TestController {
    @Value("${testName}")
    String testName;

    @Autowired
    TestService testService;

    @Override
    public String toString() {
        return "TestController{" +
                "testName='" + testName + '\'' +
                ", testService=" + testService +
                '}';
    }
}

package aoptest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/9/13 22:32
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
@Aspect
public class AspectJTest {

    @Pointcut("execution(* *.say(..))")
    public void test(){}

    @Before("test()")
    public void before(){
        System.out.println("before test..");
    }

    @After("test()")
    public void after(){
        System.out.println("after test..");
    }

    @Around("test()")
    public Object around(ProceedingJoinPoint p){
        System.out.println("before1");
        Object o = null;
        try {
            o = p.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("after1");
        return o;
    }

}

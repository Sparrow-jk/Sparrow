package proxypattern.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Sparrow
 * @description 代理类 身份认证 和 打印车票功能
 */
public class DynamicProxy implements InvocationHandler {

    private SellTicket trainStation;

    public DynamicProxy(SellTicket trainStation) {
        this.trainStation = trainStation;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        checkId();
        method.invoke(trainStation, args);
        printTicket();
        return null;

    }

    private void checkId() {
        System.out.println("身份认证中...");
    }

    private void printTicket() {
        System.out.println("车票打印中...");
    }
}

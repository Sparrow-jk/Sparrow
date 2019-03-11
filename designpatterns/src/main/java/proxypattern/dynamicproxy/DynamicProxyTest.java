package proxypattern.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author Sparrow
 */
public class DynamicProxyTest {
    public static void main(String[] args) {

        SellTicket trainStation = new TrainStation();

        InvocationHandler handler = new DynamicProxy(trainStation);

        SellTicket sellTicketProxy = (SellTicket) Proxy.newProxyInstance(trainStation.getClass().getClassLoader(), trainStation.getClass().getInterfaces(), handler);

        System.out.println(handler.getClass().getClassLoader());
        System.out.println(trainStation.getClass().getClassLoader());
        sellTicketProxy.sellTicket();
        System.out.println("售票已完成");
    }
}

package com.sparrow.demo;

import java.util.EventObject;

/**
 * @author Sparrow
 */
public class IEvent extends EventObject {
    private String eventType;

    public IEvent(Object source) {
        super(source);
    }

    public void doEvent(){
        System.out.println("通知一个事件源 source :"+ this.getSource());
    }
}

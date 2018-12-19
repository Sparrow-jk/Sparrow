package com.sparrow.listenerpattern;


import java.util.EventListener;

/**
 * @author Sparrow
 */
public interface IListener extends EventListener {

    /**
     * 事件处理
     * @param event  事件
     */
    void handleEvent(IEvent event);
}

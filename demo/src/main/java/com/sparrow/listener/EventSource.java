package com.sparrow.listener;

import java.util.Vector;

/**
 * @author Sparrow
 */
public class EventSource {

    /**
     * 监听器列表，监听器的注册则加入此列表
     */
    private Vector<IListener> listenerList = new Vector<>();

    /**
     * 注册监听器
     *
     * @param iListener 监听器
     */
    public void registerListener(IListener iListener) {
        listenerList.add(iListener);
    }

    /**
     * 撤销注册
     *
     * @param iListener 监听器
     */
    public void removeListener(IListener iListener) {
        listenerList.remove(iListener);
    }

    /**
     * 处理外部事件
     *
     * @param event 外部事件
     */
    public void notifyListenerEvents(IEvent event) {
        for (IListener iListener : listenerList) {
            iListener.handleEvent(event);
        }
    }

}

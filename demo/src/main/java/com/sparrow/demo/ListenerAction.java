package com.sparrow.demo;

/**
 * @author Sparrow
 */
public class ListenerAction {

    public static void main(String[] args) {
        EventSource eventSource = new EventSource();

        eventSource.registerListener(event -> {
            event.doEvent();
            if (event.getSource().equals("closeWindows")) {
                System.out.println("doClose");
            }
        });

        /*
         * 传入openWindows事件，通知listener，事件监听器，对open事件感兴趣的listener将会执行
         **/
        eventSource.notifyListenerEvents(new IEvent("closeWindows"));

    }

}

package listenerpattern;


import java.util.EventListener;

/**
 * @author Sparrow
 */
public interface IListener extends EventListener {

    String CLOSE= "close";

    String OPEN = "open";

    /**
     * 事件处理
     *
     * @param event 事件
     */
    void handleEvent(IEvent event);
}

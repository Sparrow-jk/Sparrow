package listenerpattern;


import java.util.EventListener;

/**
 * @author Sparrow
 */
public interface IListener extends EventListener {

    String CLOSEWINDOWS = "closeWindows";

    String OPENWINDOWS = "openWindows";

    /**
     * 事件处理
     *
     * @param event 事件
     */
    void handleEvent(IEvent event);
}

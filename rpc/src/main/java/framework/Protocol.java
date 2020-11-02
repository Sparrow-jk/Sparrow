package framework;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/9/29 1:42
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public interface Protocol {

    void start(URL url);

    String send(String hostname, int port, Invocation invocation);
}

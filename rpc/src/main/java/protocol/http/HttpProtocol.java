package protocol.http;

import framework.Invocation;
import framework.Protocol;
import framework.URL;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/9/29 1:44
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class HttpProtocol implements Protocol {
    @Override
    public void start(URL url) {
        new HttpServer().start(url.getHostname(), url.getPort());
    }

    @Override
    public String send(String hostname, int port, Invocation invocation) {
        return new HttpClient().send(hostname, port, invocation);
    }
}

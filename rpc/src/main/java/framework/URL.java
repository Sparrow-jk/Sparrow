package framework;

import java.io.Serializable;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/9/29 0:02
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class URL implements Serializable {


    private String hostname;

    private int port;

    public URL(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}

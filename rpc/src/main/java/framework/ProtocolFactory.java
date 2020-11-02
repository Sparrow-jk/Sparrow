package framework;

import protocol.http.HttpProtocol;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/9/29 1:55
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class ProtocolFactory {

    public static Protocol getProtocol() {


        String protocal = System.getProperty("protocol");

        if (protocal == null || protocal.equals("")) protocal = "http";

        switch (protocal) {
            case "http":
                return new HttpProtocol();
            default:
                break;
        }
        return new HttpProtocol();

    }
}

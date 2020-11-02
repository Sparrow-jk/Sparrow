package dubbo;


import org.apache.dubbo.common.URL;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/10/13 10:25
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
//@Adaptive
public class ThriftAdaptive implements ServiceProviderInterface {
    @Override
    public String echo(String msg, URL url) {
        return "thrift";
    }
}

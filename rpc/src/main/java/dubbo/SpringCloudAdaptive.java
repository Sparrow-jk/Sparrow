package dubbo;


import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/10/13 10:24
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
//@Adaptive
public class SpringCloudAdaptive implements ServiceProviderInterface {
    @Override
    public String echo(String msg, URL url) {
        return "SpringCloud";
    }
}

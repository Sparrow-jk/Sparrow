package dubbo;


import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;


/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/10/13 10:19
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
@SPI("dubbo")
public interface ServiceProviderInterface {

    @Adaptive({"t"})
    String echo(String msg, URL url);
}

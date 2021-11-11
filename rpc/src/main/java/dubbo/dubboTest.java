package dubbo;


import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/10/13 10:18
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class dubboTest {


    @Test
    public void test1() {
        ExtensionLoader<ServiceProviderInterface> loader = ExtensionLoader.getExtensionLoader(ServiceProviderInterface.class);
        ServiceProviderInterface testCaseSPI = loader.getAdaptiveExtension();
       // URL url = URL.valueOf("test://localhost/test?thrift");
        URL url = URL.valueOf("test://localhost/test?service.provider.interface=thrift");
        System.out.println(testCaseSPI.echo("d",url));
    }

}

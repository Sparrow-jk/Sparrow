package testSetPropertyValues;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/9/13 16:49
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
@Configuration
@ComponentScan("testSetPropertyValues")
@PropertySource(value = "classpath:/application.properties")
public class ConfigClass {
}

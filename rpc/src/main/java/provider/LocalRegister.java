package provider;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/9/28 23:52
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class LocalRegister {


    private static final Map<String, Class<?>> map = new HashMap<>();

    public static void registry(String interfaceName, Class<?> implClass) {
        map.put(interfaceName, implClass);
    }

    public static Class<?> getImpl(String interfaceName) {
        return map.get(interfaceName);
    }

}

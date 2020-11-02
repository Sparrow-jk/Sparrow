package protocol.http;

import framework.Invocation;
import org.apache.commons.io.IOUtils;
import provider.LocalRegister;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/9/28 23:49
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class HttpServerHandler {

    public void handler(HttpServletRequest request, HttpServletResponse response) {

        try {
            InputStream inputStream = request.getInputStream();

            ObjectInputStream ois = new ObjectInputStream(inputStream);
            Invocation invocation = (Invocation) ois.readObject();

            Class<?> impl = LocalRegister.getImpl(invocation.getInterfaceName());

            Method method = impl.getMethod(invocation.getMethodName(), invocation.getParamTypes());
            String result = (String) method.invoke(impl.newInstance(), invocation.getParams());

            IOUtils.write(result, response.getOutputStream());

        } catch (IOException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}

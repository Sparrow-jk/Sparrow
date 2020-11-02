package protocol.http;

import framework.Invocation;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/9/29 0:13
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class HttpClient {

    public String send(String hostname, int port, Invocation invocation) {

        try {
            URL url = new URL("http", hostname, port, "/");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();


            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);

            OutputStream outputStream = urlConnection.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);


            oos.writeObject(invocation);
            oos.flush();
            oos.close();


            InputStream inputStream = urlConnection.getInputStream();

            return IOUtils.toString(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }
}

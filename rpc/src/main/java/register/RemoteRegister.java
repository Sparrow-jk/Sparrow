package register;

import framework.URL;

import java.io.*;
import java.util.*;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/9/29 0:01
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class RemoteRegister {

    private static Map<String, List<URL>> REGISTER = new HashMap<>();

    public static void registry(String interfaceName, URL url) {

        List<URL> urls = REGISTER.get(interfaceName);
        if (urls == null) {
            urls = Collections.singletonList(url);
            REGISTER.put(interfaceName, urls);
        } else {
            urls.add(url);
        }
        saveFile();

    }

    public static URL getUrl(String interfaceName) {
        REGISTER = getFile();

        assert REGISTER != null;
        List<URL> urls = REGISTER.get(interfaceName);
        Random random = new Random();
        int i = random.nextInt(urls.size());
        return urls.get(i);
    }


    private static void saveFile() {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\vitamin\\Desktop\\temp.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(REGISTER);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Map<String, List<URL>> getFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\vitamin\\Desktop\\temp.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Map<String, List<URL>>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

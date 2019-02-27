package com.john.protocol.http;

import com.john.protocol.invocation.Invocation;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: 张彦斌
 * @Date: 2019-02-26 16:27
 */
public class HttpClient {


    public String post(String hostName, Integer port, Invocation invocation){

        try {
            URL url = new URL("http", hostName, port, "/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");

            OutputStream outputStream = connection.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(invocation);
            oos.flush();

            InputStream inputStream = connection.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            String result = (String) ois.readObject();
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

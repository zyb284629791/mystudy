package com.john.protocol.http;

import com.john.MapRegister;
import com.john.protocol.invocation.Invocation;
import com.john.register.URL;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: 张彦斌
 * @Date: 2019-02-26 16:01
 */
public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp){

        // 获取参数 invocation
        try {
            ServletInputStream inputStream = req.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            Invocation invocation = (Invocation) ois.readObject();

            // 从 invocation中获取参数，得到方法路由，执行方法
            URL url = new URL("localhost",8080);
            Class serviceImpl = MapRegister.get(invocation.getInterfaceName(), url);
            Method method = serviceImpl.getMethod(invocation.getMethodName(),invocation.getParamTypes());
            Object result = method.invoke(serviceImpl.newInstance(), invocation.getParameters());

            ServletOutputStream outputStream = resp.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(result);
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}

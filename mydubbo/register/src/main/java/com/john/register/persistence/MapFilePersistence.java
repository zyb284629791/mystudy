package com.john.register.persistence;

import com.john.register.URL;

import java.io.*;
import java.util.Map;

/**
 * @Author: 张彦斌
 * @Date: 2019-02-27 11:14
 */
public class MapFilePersistence implements Persistence {

    String path = System.getProperty("java.io.tmpdir") + "register.txt";

    @Override
    public void persist(Map<String, Map<URL, Class>> register) {

        try {
            File tmp = new File(path);
            FileOutputStream fos = new FileOutputStream(tmp);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(register);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, Map<URL, Class>> loadMapRegister() {
        File file = new File(path);
        Map<String, Map<URL, Class>> register = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            register = (Map<String, Map<URL, Class>>) ois.readObject();
            ois.close();
            fis.close();
            boolean delete = file.delete();
            System.out.println(delete);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return register;
    }
}

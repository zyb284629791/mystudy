package com.john.framework;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

/**
 * @Author: 张彦斌
 * @Date: 2019-01-14 10:37
 */
public class TomcatStarter {

    public static void run(){
        Tomcat tomcat = new Tomcat();
        String bathPath = TomcatStarter.class.getResource("/").getPath();
        System.out.println(bathPath);
        try {
            Context context = tomcat.addWebapp("", new File("myboot/src/main/resources/static").getAbsolutePath());
            WebResourceRoot resources = new StandardRoot(context);
            resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                    bathPath, "/"));
            context.setResources(resources);
            tomcat.start();
            tomcat.getServer().await();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}

package com.zhaoxuyan.listener;

import com.zhaoxuyan.utils.RWCount;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;

public class CountListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 读count.txt
        try {
            int count = RWCount.read(sce.getServletContext().getRealPath("/"));
            sce.getServletContext().setAttribute("count", count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        String count = sce.getServletContext().getAttribute("count").toString();
        try {
            RWCount.write(sce.getServletContext().getRealPath("/"), count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

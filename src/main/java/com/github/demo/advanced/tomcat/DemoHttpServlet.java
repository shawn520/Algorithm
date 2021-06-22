package com.github.demo.advanced.tomcat;

import org.apache.catalina.connector.RequestFacade;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Shawn
 * @date 2021/4/5
 */
public class DemoHttpServlet extends HttpServlet {

    //servlet在哪里调用？
    //HttpServletRequest实现类是什么，由谁实现？部署在tomcat则由tomcat实现，jetty
    // DemoHttpServlet demoHttpServlet = new DemoHttpServlet();
    // demoHttpServlet.doGet(req, resp);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestFacade requestFacade = (RequestFacade)req;
        resp.getWriter().println("demo http");
    }
}

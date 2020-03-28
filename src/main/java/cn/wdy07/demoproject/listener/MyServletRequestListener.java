package cn.wdy07.demoproject.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * @author wdy
 * @create 2020-03-12 18:04
 */
@Component
public class MyServletRequestListener implements ServletRequestListener {

    private static final Logger logger = LoggerFactory.getLogger(MyServletRequestListener.class);


    /*public void requestInitialized(ServletRequestEvent sre) {
        ServletRequest servletRequest = sre.getServletRequest();
        System.out.println("RemoteAddr--->"+servletRequest.getRemoteAddr());
        System.out.println("Request监听器====");
        servletRequest.setAttribute("name","阿哈");
    }
    public void requestDestroyed(ServletRequestEvent sre) {
        ServletRequest servletRequest = sre.getServletRequest();
        System.out.println("取出存入的name---->"+servletRequest.getAttribute("name"));
        System.out.println("request end");
    }*/

}

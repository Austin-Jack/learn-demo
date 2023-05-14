package cn.llynsyw.web.extend.component.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionBindingListener, HttpSessionListener {
    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext sc=httpSessionEvent.getSession().getServletContext();
        Object obj=sc.getAttribute("count");
        int count=0;
        if (obj!=null){
            count=(int)obj;
            count++;
        }
        sc.setAttribute("count",count);

        httpSessionEvent.getSession().setMaxInactiveInterval(5);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext sc=httpSessionEvent.getSession().getServletContext();
        Object obj=sc.getAttribute("count");
        int count=0;
        if (obj!=null){
            count=(int)obj;
            count--;
        }
        sc.setAttribute("count",count);
    }

}

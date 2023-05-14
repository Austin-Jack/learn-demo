package cn.llynsyw.web.extend.component.control;

import cn.llynsyw.web.extend.component.entity.User;
import cn.llynsyw.web.extend.component.service.UserService;
import cn.llynsyw.web.extend.component.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    UserService userService=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("name");
        String password=request.getParameter("pwd");

        //封装对象
        User user=new User(name,password);
        System.out.println(user);
        User u=userService.checkUser(user);

        System.out.println(u);
        if (u!=null){
            Cookie c=new Cookie("uid",u.getId()+"");
            //c.setPath("/CookieServlet"); //将此cookie限定在该路径下
            c.setMaxAge(360);
            request.getSession().setAttribute("user",u);
            response.addCookie(c);
            response.sendRedirect("hello");
        }else {
            response.getWriter().write("failure <a href=\"PageServlet\">重新登录</a>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

    }
}

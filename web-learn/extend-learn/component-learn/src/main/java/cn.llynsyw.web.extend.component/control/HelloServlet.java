package cn.llynsyw.web.extend.component.control;


import cn.llynsyw.web.extend.component.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        response.getWriter().write("<h1>欢迎"+((User)request.getSession().getAttribute("user")).getName()+"登录</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        this.doGet(request,response);
    }
}

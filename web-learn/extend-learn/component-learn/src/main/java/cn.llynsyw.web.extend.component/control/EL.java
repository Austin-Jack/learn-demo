package cn.llynsyw.web.extend.component.control;


import cn.llynsyw.web.extend.component.entity.Address;
import cn.llynsyw.web.extend.component.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class EL extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        User user=new User("张三","123",new Address("湖南","长沙","天心"));
        request.setAttribute("user",user);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        this.doGet(request,response);

    }
}

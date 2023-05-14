package cn.llynsyw.web.curriculum.exp_6.controller;


import cn.llynsyw.web.curriculum.exp_6.beans.UserBean;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TreatZhuCe extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name="";
        String password="";
        String confirm="";
        String message="";
        name=request.getParameter("name");
        password=request.getParameter("password");
        confirm=request.getParameter("confirm");
        if ("".equals(name)||"".equals(password)){
            message="账号和密码不能为空";
        }else if (!password.equals(confirm)){
            message="两次密码不相同";
        }else {      //符合要求
            UserBean user=new UserBean(name,password);  //新建一个UserBean

            //获取上下文
            ServletContext application = getServletContext();  //存入application中
            application.setAttribute("user",user);
        }
        request.setAttribute("message",message);
        request.getRequestDispatcher("zhuCeResult.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

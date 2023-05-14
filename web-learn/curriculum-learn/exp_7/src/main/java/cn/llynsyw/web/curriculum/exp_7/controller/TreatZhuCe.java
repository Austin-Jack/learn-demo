package cn.llynsyw.web.curriculum.exp_7.controller;


import cn.llynsyw.web.curriculum.exp_7.beans.User;
import cn.llynsyw.web.curriculum.exp_7.service.UserService;
import cn.llynsyw.web.curriculum.exp_7.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TreatZhuCe extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("confirm");
        String message = "";
        if ("".equals(name) || "".equals(password)) {
            message = "用户名或者密码不能为空";
        } else if (!password.equals(passwordConfirm)) {
            message = "两次输入密码不相同";
        } else {
            User user = new User(name,password);
            //如果插入失败则提示
            if (!userService.insertUser(user)) {
                message = "该用户已存在";
            }
        }
        request.setAttribute("message", message);
        request.getRequestDispatcher("zhuCeResult.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

}

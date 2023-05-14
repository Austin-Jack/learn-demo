package cn.llynsyw.web.curriculum.exp_7.controller;


import cn.llynsyw.web.curriculum.exp_7.beans.User;
import cn.llynsyw.web.curriculum.exp_7.service.UserService;
import cn.llynsyw.web.curriculum.exp_7.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TreatDengLu extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String message = "";
        if ("".equals(name) || "".equals(password)) {
            message = "账号和密码不能为空";
        } else {
            User user = new User(name, password);
            //如果用户信息错误则会返回null
            user = userService.checkUser(user);
            if (user == null) {
                message = "不存在该账号,登录失败";
            } else {
                //将user的id值放入session中 以便下次一登录
                request.getSession().setAttribute("UserId", user.getId());
            }
        }

        request.setAttribute("message", message);
        //结果转发到dengLuResult.jsp
        request.getRequestDispatcher("dengLuResult.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

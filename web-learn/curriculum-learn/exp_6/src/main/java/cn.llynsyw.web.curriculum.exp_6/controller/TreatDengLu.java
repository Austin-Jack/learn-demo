package cn.llynsyw.web.curriculum.exp_6.controller;


import cn.llynsyw.web.curriculum.exp_6.beans.UserBean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class TreatDengLu extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String message="";
        if("".equals(name)||"".equals(password)){
            message="账号和密码不能为空";
        }else {
            //查看application中是否有user
            UserBean user= (UserBean) getServletContext().getAttribute("user");
            if (user!=null) {
                String userName = user.getName();
                String userPassword = user.getPassword();
                if (userName.equals(name) && userPassword.equals(password)) {  //用户名和密码都匹配
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);  //存入session中
                } else { //密码不匹配
                    message = "账号或者密码不正确";
                }
            }else {
                message="不存在用户,请先注册";
                response.setHeader("refresh","3;URL=zhuce.jsp");
            }
        }

        request.setAttribute("message",message);
        //结果转发到dengLuResult.jsp
        request.getRequestDispatcher("dengLuResult.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        this.doGet(request,response);
    }
}

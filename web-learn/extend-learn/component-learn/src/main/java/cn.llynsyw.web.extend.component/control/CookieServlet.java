package cn.llynsyw.web.extend.component.control;

import cn.llynsyw.web.extend.component.entity.User;
import cn.llynsyw.web.extend.component.service.UserService;
import cn.llynsyw.web.extend.component.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class CookieServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        request.setCharacterEncoding("utf-8");
        Cookie[] cookies = request.getCookies(); //获取cookies
        User u = null;
        if (cookies.length != 0) {  //避免没有cookie造成空指针
            for (Cookie cookie : cookies) {
                if ("uid".equals(cookie.getName())) {
                    String uid = cookie.getValue();
                    System.out.println(uid);
                    try {
                        //可能获取的不是整数
                        u = userService.getById(Integer.parseInt(uid));
                    } catch (Exception e) {
                        System.out.println("uid识别异常");
                    }
                } else { //key不为uid
                    continue;
                }
            }
        }

        if (u != null) {
            response.sendRedirect("hello");
        } else {//遍历完成或者没有对应的uid
            request.getRequestDispatcher("login").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        this.doPost(request, response);
    }
}

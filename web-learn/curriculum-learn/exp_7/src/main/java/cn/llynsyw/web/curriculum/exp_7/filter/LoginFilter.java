package cn.llynsyw.web.curriculum.exp_7.filter;

import cn.llynsyw.web.curriculum.exp_7.service.impl.UserServiceImpl;
import cn.llynsyw.web.curriculum.exp_7.service.UserService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LoginFilter implements Filter {
    UserService userService=new UserServiceImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        Object userId = request.getSession().getAttribute("UserId");
        if (userId!=null){  //则表示有过登录记录
            request.setAttribute("user",userService.getUserById((int)userId));  //将其放入request中

            request.getRequestDispatcher("dengLuResult.jsp").forward(servletRequest,servletResponse);
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}

package cn.llynsyw.web.extend.component.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("登录session处理");
        HttpSession session=((HttpServletRequest)servletRequest).getSession();
        if (session.getAttribute("user")==null){ //session不存在user
            ((HttpServletRequest)servletRequest).getRequestDispatcher("Cookie").forward((HttpServletRequest)servletRequest
                    ,(HttpServletResponse)servletResponse);
        }else {
            ((HttpServletResponse)servletResponse).sendRedirect("hello");
        }

    }

    @Override
    public void destroy() {

    }
}

package cn.llynsyw.web.extend.component.control;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class PageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("text/html;charset=gbk");
        PrintWriter writer = response.getWriter();
        writer.write("<html> <head> </head> <body> <form action='loginFilter' method='get'>");
        writer.write("用户名:<input type='text' name='name' value=''> <br/>");
        writer.write("密码:<input type='password' name='pwd' value='' <br/>");
        writer.write("<input type='submit'  value='login'>");
        writer.write("</form>");
        writer.write("</body>");
        writer.write("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

    }
}

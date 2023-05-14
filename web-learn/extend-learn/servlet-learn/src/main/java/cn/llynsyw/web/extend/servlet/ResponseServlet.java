import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        /*响应头
        * 响应行
        * 响应体
        *
        * */
        /*都会在响应行中加入键值对*/
        response.setHeader("key","vaule1"); //相同的key会被覆盖
        response.setHeader("key","vaule2"); //相同的key会被覆盖
        response.setHeader("Content-Type","application/msword");

        response.addHeader("city","changsha");//相同的key不会被覆盖
        response.addHeader("city","chongqing");//可以存在两个键值对


        /*响应行*/
        //response.sendError(404,"not fuck found"); //设置响应状态码
        String str="yes you are right";
        StringBuilder builder=new StringBuilder();
        builder.append("<h1>")
                .append(str)
                .append("</h1>");
        response.getWriter().write(String.valueOf(builder));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {


    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}

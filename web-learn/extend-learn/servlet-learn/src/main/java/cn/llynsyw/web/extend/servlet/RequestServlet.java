import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;


public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            请求行
            请求头
            请求体
         */
        //获取完整地址
        System.out.println(request.getRequestURL());
        //获取 虚拟项目名/请求资源
        System.out.println(request.getRequestURI());

        //获取请求协议
        System.out.println(request.getScheme());

        //获取请求行对应的所有的请求信息的key
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            System.out.println(key+":"+value);
        }
        System.out.println("====================================");

        String remoteAddr = request.getRemoteAddr();//远程客户端的地址
        String remoteHost = request.getRemoteHost();//获取远程客户端的主机名称
        int remotePort = request.getRemotePort();//获取远程客户端口号
        System.out.println(remoteAddr+":"+remoteHost+":"+remotePort);

        String localAddr = request.getLocalAddr();
        String localName = request.getLocalName();
        System.out.println(request.getLocalPort());
        System.out.println(localAddr+":"+localName);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

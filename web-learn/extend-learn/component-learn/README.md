Controller设置Cookie第一种方式：
写：Response.SetCookie(new HttpCookie("mycookie"){ Value="1234" });
读：Request.Cookies["mycookie"].Value;

Controller设置Cookie第二种方式：
写：Response.Cookies.Add(new HttpCookie("Customer") { Value = Server.UrlEncode(source.Result.Data), Expires = DateTime.Now.AddDays(300) });
读：string customer = Server.UrlDecode(Request.Cookies["Customer"].Value);

首先还是要打开指定网址
接着在 Console 下输入命令
document.cookie="key=value"


ServletContext 与application的异同
相同：其实servletContext和application 是一样的，就相当于一个类创建了两个不同名称的变量。在

      servlet中ServletContext就是application对象。大家只要打开jsp编译过后生成的Servlet中的
    
      _jspService()方法就可以看到如下的声明：
            ServletContextapplication = null;
    
            application= pageContext.getServletContext();

不同：两者的区别就是application用在jsp中，servletContext用在servlet中。application和page

      requestsession 都是JSP中的内置对象，在后台用ServletContext存储的属性数据可以用
    
      application对象获得。


而且application的作用域是整个Tomcat启动的过程。
例如:ServletContext.setAttribute("username",username);
则在JSP网页中可以使用  application.getAttribute("username");
来得到这个用户名。


当有多个过滤器对同一个请求进行拦截时，
根据web.xml文件中<filter-mapping>的配置顺序，谁在前，先执行谁。
当第 一过滤器拦截成功后，会执行doFilter方法，该方法中，调用chain.doFilter方法，
会将该请求放行给下一个过滤器，依次执行，直到执行 到最后一个过滤器，
当最后一个过滤器调用chain.doFilter方法时，请求会被放行给Servlet，
当Servlet处理返回响应信息时，先返 回到最后执行的过滤器，继续执行该过滤器剩下的代码。
依次返回，直到返回到第一个过滤器，最后返回给客户端。


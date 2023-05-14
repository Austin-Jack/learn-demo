<%@ page import="com.lly.entity.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: l2215
  Date: 2021/10/1
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>index</title>
</head>
<body>

<a href="loginFilter">登录</a>
<br>
在线人数：${applicationScope.count}
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    User u = null;
    Object object = request.getAttribute("user");
    if (object != null) {
        u = (User) object;
    }
%>
<h3>路径</h3>
<base href=<%=basePath%>"">
<%--http://localhost:80/learnweb02/--%>
<%=basePath%>

<%--
传统方式获取值
弊端:
    1.必须导包
    2.需要进行强制类型转换
    3.层次结构比较复杂
--%>

<h3>传统获取值</h3>
<p>
    <%=u%>  <%--相当于out.println(u);  然后会默认调用toString--%>
</p>

<h3>EL表达式</h3>
<%--
  EL表达式
    $(expression) 允许使用[]和.
--%>
town:${user.address.town}

<h3>JSTL</h3>
<%--
JSTL
  配置taglib
--%>
<%request.setAttribute("str", "happy");%>
<%--输出标签 当获取到EL表达式时输出value 跳过default--%>
<c:out value="${str}" default="呜呜呜"></c:out>
<br>
<%--如果获取不到则输出default指定值--%>
<c:out value="${str2}" default="呜呜呜"></c:out>

<%--
  向作用域存取数据
  默认向PageContex作用域中写入键值对 可以通过scope来配置范围
  取值时通过scope手动指定
--%>
<c:set var="key" value="value1" scope="page"></c:set>
<c:set var="key" value="value2" scope="request"></c:set>
<br>
<c:out value="${pageScope.key}"></c:out> <br>
<br>
<c:out value="${requestScope.key}"></c:out> <br>

<c:remove var="key" scope="page"></c:remove>


<%--
逻辑判断标签
  test="逻辑表达式"
  var="条件表达式的结果存储变量"
  scope="var的存储作用域"
--%>
<h3>逻辑分支判断</h3>
<c:set var="a" value="1"></c:set>
<c:if test="${a>=1}">
    <p>a &geq; 1 </p>
</c:if>

<c:set var="age" value="18"></c:set>
<c:choose>
    <c:when test="${0<age&&age<=10}">
        <p>儿童</p>
    </c:when>
    <c:when test="${10<age&&age<=18}">
        <p>未成年</p>
    </c:when>
    <c:when test="${18<age&&age<=30}">
        <p>少年</p>
    </c:when>
    <c:when test="${30<age&&age<=40}">
        <p>青年</p>
    </c:when>
    <c:otherwise>
        <p>年龄错误</p>
    </c:otherwise>
</c:choose>

<%--
循环标签
begin="从哪开始"
end="到哪结束"
step="步进"
varStatus="循环状态存储标识"
var="迭代变量值"
items="遍历目标"
--%>
<h3>循环表达式</h3>
<c:forEach begin="0" end="3" step="1" varStatus="sta">
    ${sta.index}---${sta.count}---${sta.first}---${sta.last}
    <br>
</c:forEach>

<%
    ArrayList<String> list = new ArrayList<>();
    list.add("aaa");
    list.add("bbb");
    list.add("ddd");
    request.setAttribute("list", list);
%>
<%--类似于foreach 不会造成数组右越界--%>
<p>
    <c:forEach begin="0" end="2" var="i" items="${list}">;
        ${i}
    </c:forEach>
</p

<%--动态显示表格--%>
<%
    Map<Integer, String> map = new HashMap();
    map.put(1, "aaa");
    map.put(2, "bbb");
    map.put(3, "ccc");
    request.setAttribute("map", map);
%>

<br> <%--有坑 这里不写一个html标签它识别不了table--%>
<table border="1px" cellspacing="0">
    <tr>
        <th>key</th>
        <th>value</th>
    </tr>
    <c:forEach begin="0" end="3" var="i" items="${map}">
        <tr>
            <td>${i.key}</td>
            <td>${i.value}</td>
        </tr>
    </c:forEach>

</table>
<%--格式化输出标签--%>
<h3>数字格式化:</h3>
<c:set var="balance" value="120000.2309" />
<p>格式化数字 (1): <fmt:formatNumber value="${balance}"
                                type="currency"/></p>
<p>格式化数字 (2): <fmt:formatNumber type="number"
                                maxIntegerDigits="3" value="${balance}" /></p>
<p>格式化数字 (3): <fmt:formatNumber type="number"
                                maxFractionDigits="3" value="${balance}" /></p>
<p>格式化数字 (4): <fmt:formatNumber type="number"
                                groupingUsed="false" value="${balance}" /></p>
<p>格式化数字 (5): <fmt:formatNumber type="percent"
                                maxIntegerDigits="3" value="${balance}" /></p>
<p>格式化数字 (6): <fmt:formatNumber type="percent"
                                minFractionDigits="10" value="${balance}" /></p>
<p>格式化数字 (7): <fmt:formatNumber type="percent"
                                maxIntegerDigits="3" value="${balance}" /></p>
<p>格式化数字 (8): <fmt:formatNumber type="number"
                                pattern="###.###E0" value="${balance}" /></p>
<p>美元 :
    <fmt:setLocale value="en_US"/>
    <fmt:formatNumber value="${balance}" type="currency"/></p>
</body>
</html>

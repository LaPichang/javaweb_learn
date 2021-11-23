<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="综合练习_登录案例.User" %><%--
  Created by IntelliJ IDEA.
  User: 13992
  Date: 2021/8/11
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%
    List list = new ArrayList();
    list.add(new User(1,"爱德华","520"));
    list.add(new User(2,"王得发","521"));
    list.add(new User(3,"王二麻","1314"));

    request.setAttribute("list",list);
%>

<table border="1" width="500" align="center">
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>密码</td>
    </tr>

    <%--数据行--%>
    <c:forEach items="${list}" var="user" varStatus="s">

        <c:if test="${s.count % 2 == 0}">
            <tr bgcolor="#7fffd4">
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
            </tr>
        </c:if>

        <c:if test="${s.count % 2 != 0}">
            <tr bgcolor="orange">
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
            </tr>
        </c:if>


    </c:forEach>

</table>

</body>
</html>

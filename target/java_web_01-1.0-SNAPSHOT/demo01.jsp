<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 13992
  Date: 2021/8/11
  Time: 20:14
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
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    request.setAttribute("list",list);

%>

<c:if test="${not empty list}">

    <c:forEach items="${list}" var="str" varStatus="s">
        
        <c:choose>
            <c:when test="${str.equal(s[0])}">AAA</c:when>
            <c:when test="${str.equal(s[1])}">BBB</c:when>
            <c:when test="${str.equal(s[2])}">CCC</c:when>
        </c:choose>

    </c:forEach>

</c:if>

</body>
</html>

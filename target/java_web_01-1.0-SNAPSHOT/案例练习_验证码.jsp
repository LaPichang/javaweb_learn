<%--
  Created by IntelliJ IDEA.
  User: 13992
  Date: 2021/7/27
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证码</title>


    <script>
        window.onload = function (){
            document.getElementById("img").onclick = function (){

                this.src="${pageContext.request.contextPath}/checkCodeServlet?time"+new Date().getTime();
            }
        }
    </script>


    <style>
        div{
            color: red;
        }
    </style>

</head>
<body>

<form action="${pageContext.request.contextPath}/综合案例_分页表单/LoginServlet" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input  type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input  type="password" name="password"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input  type="text" name="checkCode"></td>
        </tr>
        <tr>
            <td colspan="2"><img id="img" src="${pageContext.request.contextPath}/checkCodeServlet"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登录"></td>
        </tr>
    </table>
</form>


<%-- EL表达式 --%>
${requestScope.cc_error}
${requestScope.login_error}


<%
    if (request.getAttribute("cc_error") != null){
        out.println(request.getAttribute("cc_error"));
    }
%>
<%
    if (request.getAttribute("login_error") != null){
        out.println(request.getAttribute("login_error"));
    }
%>


</body>
</html>

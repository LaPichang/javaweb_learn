<%--
  Created by IntelliJ IDEA.
  User: 13992
  Date: 2021/8/12
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<head>



    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>






    <title>登录</title>



    <style>
        body{
            background-image: url("${pageContext.request.contextPath}/img/VCG211330627067.jpg");
            background-size: cover
        }

        .check{
            color: red;
        }

    </style>

    <script>
        window.onload = function (){
            document.getElementById("img").onclick = function (){

                this.src="${pageContext.request.contextPath}/checkCodeServlet?time"+new Date().getTime();
            }
        }
    </script>



</head>
<body>

<h1 align="center">管理员登录</h1>

<form action="${pageContext.request.contextPath}/LoginServlet2" method="post" class="form-horizontal">


    <div class="form-group">
        <label for="username" class="col-sm-2 control-label">用户名</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-4">
            <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
        </div>
    </div>

    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">验证码</label>
        <div class="col-sm-4">
            <td><input  type="text" name="checkCode"></td>
            <td colspan="2"><img id="img" src="${pageContext.request.contextPath}/checkCodeServlet"></td>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <div class="checkbox">
                <label>
                    <input type="checkbox"> 记住密码
                </label>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">登录</button>


            <div class="control-label check" align="center">
                <label for="username" class="col-sm-2 control-label">${requestScope.cc_error}</label>
            </div>
            <div class="control-label check" align="center">
                <label for="username" class="col-sm-2 control-label">${requestScope.login_error}</label>
            </div>


        </div>
    </div>


    <div class="control-label check" align="center">
        <label for="username" class="col-sm-2 control-label">${requestScope.login_mag}</label>
    </div>




</form>



</body>
</html>

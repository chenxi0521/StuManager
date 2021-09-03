<%--
  Created by IntelliJ IDEA.
  User: chenxi
  Date: 2021/8/26
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="UTF-8">
<title>登录</title>
<style>
    #bigbox{
        width: 400px;
        margin: 0 auto;
    }

    form{
        width: 400px;

    }

</style>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>

<%
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("uname")){
            pageContext.setAttribute("uname",cookie.getValue());
        }
        if (cookie.getName().equals("pwd")){
            pageContext.setAttribute("pwd",cookie.getValue());
        }
        if (cookie.getName().equals("rem")){
            pageContext.setAttribute("rem",cookie.getValue());
        }
    }
%>
</head>
<body>
<div id="bigbox">
    <h3>登录</h3>
    <form action="user" method="post">
    <%--    <br>--%>
        <input type="hidden" name="type" value="login">
    <%--    账号:<input type="text" name="uname" value="${uname}"><br><br>--%>
    <%--    密码:<input type="password" name="pwd" value="${pwd}"><br><br>--%>
    <%--    <input type="checkbox" name="rem" value="ok" ${empty rem?'':'checked'} >记住密码--%>
    <%--    <input type="submit" value="登录">--%>


        <div class="mb-3">
            <label  class="form-label">账号:</label>
            <input type="text" class="form-control"  name="uname" value="${uname}">
        </div>
        <div class="mb-3">
            <label  class="form-label" >密码:</label>
            <input type="password" class="form-control"  name="pwd" value="${pwd}">
        </div>
        <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" name="rem" value="ok" ${empty rem?'':'checked'}>
            <label class="form-check-label">记住密码</label>
        </div>
        <button type="submit" class="btn btn-primary">登录</button>
    </form>
</div>
</body>
</html>
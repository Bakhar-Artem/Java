<%--
  Created by IntelliJ IDEA.
  User: Artem
  Date: 14.07.2021
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form name="Login" method="post" action="${pageContext.request.contextPath}/controller">
    <input type="hidden" name="command" value="login"/>
    <input type="text" name="login" value="">
    <br>
    <input type="text" name="password" value="">
    <input type="submit" value="log in">
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Artem
  Date: 09.07.2021
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form name="RegistrationForm" method="POST" action="${pageContext.request.contextPath}/controller">
    <input type="hidden" name="command" value="registration"/>
    <input type="text" name="name" value="">
    <br>
    <input type="text" name="lastname" value="">
    <br>
    Login:
    <input type="text" name="login" value=""/>
    <br/>Password:
    <input type="text" name="password" value="">
    <br/>
    <input type="submit" value="test"></input>
</form>

</body>
</html>

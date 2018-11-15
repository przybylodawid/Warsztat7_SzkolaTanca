<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 14.11.18
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
    <title>Login</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/fragments/menu.jsp"/>
<h1>Login Form</h1>

<form:form method="post" modelAttribute="loginDto">
    <br>
    Email:<form:input path="email" /><br>
    <form:errors path="email"/><br>
    Hasło:<form:password path="password" /><br>
    <form:errors path="password"/><br>

    <a href="/register">Rejestracja</a><br><br>

    <input type="submit" value="Login">

</form:form>
<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>

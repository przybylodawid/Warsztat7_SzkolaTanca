<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 14.11.18
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
    <title>Register</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/fragments/menu.jsp"/>
<h1>Register here</h1>
<form:form method="post" modelAttribute="registerDto">
    <br>
    Email:<br><form:input path="email" /><br>
    <form:errors path="email"/><br>
    Hasło:<br><form:password path="password" /><br>
    <form:errors path="password"/><br>
    Hasło 2:<br><form:password path="password2" /><br>
    <form:errors path="password2"/><br>
    Imię:<br><form:input path="firstName" /><br>
    <form:errors path="firstName"/><br>
    Nazwisko:<br><form:input path="lastName" /><br>
    <form:errors path="lastName"/><br>

    <input type="submit" value="Rejestracja">
</form:form>
<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>

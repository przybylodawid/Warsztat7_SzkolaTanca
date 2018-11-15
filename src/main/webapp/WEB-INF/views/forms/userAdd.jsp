<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 14.11.18
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
    <title>Title</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/fragments/menu.jsp"/>
<h1>User Add</h1>
<form:form action="" method="post"
           modelAttribute="userDto"><br>
    Imię: <br>
    <form:input path="firstName" /><br>
    <form:errors path="firstName"/><br>
    Nazwisko: <br>
    <form:input path="lastName" /><br>
    <form:errors path="lastName"/><br>
    Email: <br>
    <form:input path="email" /><br>
    <form:errors path="email"/><br>
    Opis dodatkowy: <br>
    <form:textarea path="note" /><br>
    <form:errors path="note"/><br>
    Hasło: <br>
    <form:input path="password" /><br>
    <form:errors path="password"/><br>
    Wybierz Role:<br>
    <form:checkboxes path="roles" items="${roles}"
                     itemValue="id" itemLabel="roleName"/><br>
    <form:errors path="roles"/><br>
    Wybierz czego uczy (Tylko dla Instruktorów):<br>
    <form:checkboxes path="techniques" items="${techniques}"
                     itemLabel="techniqueName" itemValue="id"/><br>
    <form:errors path="techniques"/><br>
    <br>

    <input type="submit" value="Dodaj">
</form:form>

<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>

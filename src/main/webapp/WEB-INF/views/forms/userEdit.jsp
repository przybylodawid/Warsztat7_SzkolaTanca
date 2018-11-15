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
<h1>User Edit:</h1>

<form:form action="" method="post"
           modelAttribute="user"><br>
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
    <form:hidden path="password" readonly="true" /><br>
    <form:errors path="password"/><br>
    Tokeny:<br>
    <form:input path="tokens" readonly="true"/><br>
    <form:errors path="tokens"/><br>
    Wybierz Role:<br>
    <form:checkboxes path="roles" items="${roles}"
                     itemValue="id" itemLabel="roleName"/><br>
    <form:errors path="roles"/><br>
    Wybierz czego uczy (Tylko dla Instruktorów):<br>
    <form:checkboxes path="techniques" items="${techniques}"
                     itemLabel="techniqueName" itemValue="id"/><br>
    <form:errors path="techniques"/><br>
    <br>

    <input type="submit" value="Zapisz">
</form:form>
<a href="/admin/users/delete/${user.id}">
Usuń usera ${user.firstName} ${user.lastName}
</a>
<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>

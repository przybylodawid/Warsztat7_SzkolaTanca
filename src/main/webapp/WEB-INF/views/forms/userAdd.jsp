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


    <div class="form-group">
        <label >Imie:</label>
        <form:input class="form-control" path="firstName" />
        <form:errors path="firstName"/>
    </div>

    <div class="form-group">
        <label >Nazwisko:</label>
        <form:input class="form-control" path="lastName" />
        <form:errors path="lastName"/>
    </div>
    <div class="form-group">
        <label >Email:</label>
        <form:input class="form-control" path="email" />
        <form:errors path="email"/>
    </div>
    <div class="form-group">
        <label >Opis Dodatkowy:</label>
        <form:textarea class="form-control" path="note" />
        <form:errors path="note"/>
    </div>
    <div class="form-group">
    <label >Haslo:</label>
    <form:input class="form-control" path="password" />
    <form:errors path="password"/>
    </div>
    <div class="form-group">
        <label >Tokeny:</label>
        <form:input class="form-control" path="tokens"/><br>
        <form:errors path="tokens"/><br>
    </div>
    Wybierz Role:<br>
    <form:checkboxes path="roles" items="${roles}"
                     itemValue="id" itemLabel="roleName"/><br>
    <form:errors path="roles"/><br>
    Wybierz czego uczy (Tylko dla Instruktorów):<br>
    <form:checkboxes path="techniques" items="${techniques}"
                     itemLabel="techniqueName" itemValue="id"/><br>
    <form:errors path="techniques"/><br>
    <br>

    <input class="btn btn-primary" type="submit" value="Zapisz">
</form:form>

<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 15.11.18
  Time: 11:56
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
<h1>Edytuj kurs</h1>
<form:form action="" method="post"
           modelAttribute="course"><br>
    Dzień:<form:select path="day" items="${days}"/><br>
    <form:errors path="day"/>
    Godzina:<form:select path="hour" items="${hours}"/><br>
    <form:errors path="hour"/>

    Technika:<form:select path="technique" items="${techniques}" itemLabel="techniqueName" itemValue="id"/><br>
    <form:errors path="technique"/><br>
    Wybierz Instruktorów:<br>
    <form:checkboxes path="users" items="${teachers}" itemLabel="fullName" itemValue="id"/><br>
    Wybierz Kursantów:<br>
    <form:checkboxes path="users" items="${users}" itemValue="id" itemLabel="fullName"/><br>
    <input type="submit" value="Zapisz">
</form:form>
<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>


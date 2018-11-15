<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 15.11.18
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Course Add</title>
</head>
<body>
<h1>Dodaj kurs</h1>
<form:form action="" method="post"
           modelAttribute="courseDto"><br>
    Dzień:<form:select path="day" items="${days}"/><br>
    <form:errors path="day"/>
    Godzina:<form:select path="hour" items="${hours}"/><br>
    <form:errors path="hour"/>

Technika:<form:select path="technique" items="${techniques}" itemLabel="techniqueName" itemValue="id"/><br>
<form:errors path="technique"/><br>
Wybierz Instruktorów:<br>
    <form:checkboxes path="teachers" items="${teachers}" itemLabel="fullName" itemValue="id"/>
Wybierz Kursantów:<br>
    <form:checkboxes path="students" items="${users}" itemValue="id" itemLabel="fullName"/>
    <input type="submit" value="Zapisz">
</form:form>
</body>
</html>

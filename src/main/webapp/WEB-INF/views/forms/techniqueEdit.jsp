<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 14.11.18
  Time: 09:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Technique Edit </h1>
<form:form action="" method="post"
           modelAttribute="technique"><br>
    Edytuj nazwę: <br>
    <form:input path="techniqueName" /><br>
    <form:errors path="techniqueName"/><br>

    <input type="submit" value="Zapisz Zmiany"><br>
</form:form>

<a href="/admin/techniques/delete/${technique.id}">Usuń technikę ${technique.techniqueName}</a>


</body>
</html>

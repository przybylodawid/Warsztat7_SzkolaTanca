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
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
    <title>Edycja Techniki</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/fragments/menu.jsp"/>
<h1> Edycja Techniki </h1>
<form:form action="" method="post"
           modelAttribute="technique"><br>
        <div class="form-group">
        <label >Edytuj nazwe</label>
        <form:input path="techniqueName" class="form-control" id="exampleInputEmail1"/>
        <form:errors path="techniqueName"/>
        </div>


    <input class="btn btn-primary" type="submit" value="Zapisz Zmiany"><br>
</form:form>

<a class="badge badge-danger" href="/admin/techniques/delete/${technique.id}">Usuń ${technique.techniqueName}</a>

<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>

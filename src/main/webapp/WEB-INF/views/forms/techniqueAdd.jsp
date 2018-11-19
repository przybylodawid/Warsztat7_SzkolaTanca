<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 13.11.18
  Time: 12:14
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
<h1>Technique Add Form</h1>

<form:form action="" method="post"
           modelAttribute="techniqueDto"><br>
    <div class="form-group">
        <label >Dodaj Technike</label>
        <form:input path="techniqueName" class="form-control" id="exampleInputEmail1"/>
        <form:errors path="techniqueName"/>
    </div>


    <input class="btn btn-primary" type="submit" value="Dodaj"><br>
</form:form>
<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 13.11.18
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Show All techniques</h1>


<c:forEach var="technique" items="${techniques}">
    <a href="/admin/techniques/edit/${technique.id}" >${technique.techniqueName}</a><br>

</c:forEach>

</body>
</html>


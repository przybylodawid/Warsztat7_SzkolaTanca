<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 15.11.18
  Time: 09:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Courses</title>
</head>
<body>
<h1>All Courses</h1>

<c:forEach var="course" items="${courses}">
    ${course.technique.techniqueName} - ${course.day} ${course.hour} TEACHERS STUDENTS <br>
</c:forEach>

</body>
</html>

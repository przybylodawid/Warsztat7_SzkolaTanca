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
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
    <title>All Courses</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/fragments/menu.jsp"/>
<h1>All Courses</h1>

<c:forEach var="course" items="${courseslist}">
    <a href="/admin/courses/edit/${course.id}">${course.technique.techniqueName} - ${course.day} ${course.hour}</a><br>
</c:forEach>
<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>

</body>
</html>

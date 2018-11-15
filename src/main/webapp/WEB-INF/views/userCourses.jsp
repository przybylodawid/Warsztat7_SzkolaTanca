<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 15.11.18
  Time: 12:55
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
<h1>All Courses for user m</h1>
Kursy na które uczęszczam:<br>
<c:forEach var="course" items="${coursesin}">
    <a href="/admin/courses/edit/${course.id}">${course.technique.techniqueName} - ${course.day} ${course.hour}</a> <a href="/user/signmeout/${course.id}" title="Wypisz mnie z tego kursu">Wypisz</a> Powiadom o mojej nieobecności<br>
</c:forEach>
<br>Pozostałe kursy:<br>
<c:forEach var="course" items="${coursesnotin}">
    <a href="/admin/courses/edit/${course.id}">${course.technique.techniqueName} - ${course.day} ${course.hour}</a> <a href="/user/signmein/${course.id}" title="Zapisz mnie na ten kurs">Zapisz</a><br>
</c:forEach>
<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>

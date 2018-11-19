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
    <title>Moje kursy</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/fragments/menu.jsp"/>
<h2>Kursy na które uczęszczam:</h2>
<c:forEach var="course" items="${coursesin}">
    <a class="badge badge-primary" href="/admin/courses/edit/${course.id}">${course.technique.techniqueName} - ${course.day} ${course.hour}</a> <a class="badge badge-danger" href="/user/signmeout/${course.id}" title="Wypisz mnie z tego kursu">Wypisz</a> <a class="badge badge-info" href="#" title="Powiadom o mojej nieobecności">NIEOBECNOŚĆ</a><br>
</c:forEach>
<h2>Pozostałe kursy:</h2>
<c:forEach var="course" items="${coursesnotin}">
    <a class="badge badge-primary" href="/admin/courses/edit/${course.id}">${course.technique.techniqueName} - ${course.day} ${course.hour}</a> <a  class="badge badge-success" href="/user/signmein/${course.id}" title="Zapisz mnie na ten kurs">Zapisz</a><br>
</c:forEach>
<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>

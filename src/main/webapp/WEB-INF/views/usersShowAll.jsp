<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 14.11.18
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
    <title>All Users</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/fragments/menu.jsp"/>
<h1>All Users</h1>

<c:forEach var="user" items="${users}">
   <a href="/admin/users/edit/${user.id}"> ${user.email} - ${user.firstName} ${user.lastName} </a> ${user.tokens}
    <a href="/admin/users/substracttokens/${user.id}/1">-1</a>
    <a href="/admin/users/addtokens/${user.id}/1">+1</a>
    <a href="/admin/users/addtokens/${user.id}/4">+4</a>
    <a href="/admin/users/addtokens/${user.id}/8">+8</a>

    <br>
</c:forEach>
<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>

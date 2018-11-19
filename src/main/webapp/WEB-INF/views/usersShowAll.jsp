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
    <title>Lista uzytkownikow</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/fragments/menu.jsp"/>
<h2>Lista uzytkownikow</h2>

<c:forEach var="user" items="${users}">
   <a class="btn btn-primary btn-sm" href="/admin/users/edit/${user.id}"> ${user.email} - ${user.firstName} ${user.lastName} </a>
    <a href="/admin/users/substracttokens/${user.id}/1"><i class="material-icons">remove_circle</i></a>
    ${user.tokens}
    <a href="/admin/users/addtokens/${user.id}/1"><i class="material-icons">add_circle</i></a>
    <a href="/admin/users/addtokens/${user.id}/4"><i class="material-icons">filter_4</i></a>
    <a href="/admin/users/addtokens/${user.id}/8"><i class="material-icons">filter_8</i></a>

    <br>
</c:forEach>
<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>

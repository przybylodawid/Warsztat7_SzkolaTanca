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
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
    <title>Lista Technik tanecznych</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/fragments/menu.jsp"/>
<h3> Show All techniques</h3>


<c:forEach var="technique" items="${techniques}">
    <a class="btn btn-primary btn-sm" href="/admin/techniques/edit/${technique.id}">${technique.techniqueName}</a><br>

</c:forEach>
<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>



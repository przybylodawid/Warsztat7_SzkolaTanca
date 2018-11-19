<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 14.11.18
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
    <title>Login</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/fragments/menu.jsp"/>

<div class="page-header header-filter" style="background-image: url('/splash.jpg'); background-size: cover; background-position: top center;">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-6 ml-auto mr-auto">
                <div class="card card-login">
                    <form:form class="form" method="post" modelAttribute="loginDto">
                        <div class="card-header card-header-primary text-center">
                            <h4 class="card-title">Zaloguj się</h4>
                            <div class="social-line">
                                <a href="#pablo" class="btn btn-just-icon btn-link">
                                    <i class="fa fa-facebook-square"></i>
                                </a>
                                <a href="#pablo" class="btn btn-just-icon btn-link">
                                    <i class="fa fa-twitter"></i>
                                </a>
                                <a href="#pablo" class="btn btn-just-icon btn-link">
                                    <i class="fa fa-google-plus"></i>
                                </a>
                            </div>
                        </div>
                        <p class="description text-center">Albo klasycznie</p>
                        <div class="card-body">

                            <div class="input-group">
                                <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="material-icons">mail</i>
                    </span>
                                </div>
                                <form:input type="email" class="form-control" placeholder="Email..." path="email" />
                                <form:errors path="email"/><br>

                            </div>
                            <div class="input-group">
                                <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="material-icons">lock_outline</i>
                    </span>
                                </div>
                                <form:password class="form-control" placeholder="Haslo..." path="password" />
                                <form:errors path="password"/><br>

                            </div>
                        </div>
                        <div class="footer text-center">


                            <input type="submit" class="btn btn-primary btn-link btn-wd btn-lg" value="Login"><br>
                            <a href="/register" class="btn btn-primary btn-link btn-wd btn-lg">Rejestracja</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</form:form>

<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>

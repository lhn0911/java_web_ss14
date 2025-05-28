<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/28/2025
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Đăng nhập</h2>
<form:form method="POST" modelAttribute="user" action="login">
  Tên đăng nhập: <form:input path="username"/><br/><br/>
  Mật khẩu: <form:password path="password"/><br/><br/>
  <input type="submit" value="Đăng nhập"/>
</form:form>

<c:if test="${not empty error}">
  <p style="color:red;">${error}</p>
</c:if>
</body>
</html>

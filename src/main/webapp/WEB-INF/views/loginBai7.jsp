<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/29/2025
  Time: 1:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Đăng nhập</h2>
<form action="${pageContext.request.contextPath}/loginBai7" method="post">
    <label>Username:</label><br>
    <input type="text" name="username" value="${cookie.username.value}" required><br><br>

    <label>Password:</label><br>
    <input type="password" name="password" value="${cookie.password.value}" required><br><br>

    <label><input type="checkbox" name="rememberMe" <c:if test="${not empty cookie.username}">checked</c:if> /> Remember me</label><br><br>

    <button type="submit">Login</button>
</form>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

</body>
</html>

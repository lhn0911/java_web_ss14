<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/28/2025
  Time: 5:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="product" action="addProduct">
    Tên sản phẩm: <form:input path="name" id="name"/> <br>
    Giá: <form:input path="price" id="price"/> <br>
    <button type="submit">Thêm mới</button>
</form:form>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/29/2025
  Time: 1:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Form đặt hàng</h2>

<form:form method="post" action="${pageContext.request.contextPath}/orderB8/submit" modelAttribute="orderB8">
    <form:label path="username">Tên người dùng:</form:label>
    <form:input path="username" />
    <br/>

    <form:label path="product">Sản phẩm:</form:label>
    <form:input path="product" />
    <br/>

    <form:label path="quantity">Số lượng:</form:label>
    <form:input path="quantity" type="number" min="1" />
    <br/>

    <input type="submit" value="Đặt hàng" />
</form:form>

<c:if test="${not empty message}">
    <p style="color:green">${message}</p>
</c:if>

<p><a href="${pageContext.request.contextPath}/orderB8/orderList">Xem đơn hàng đã đặt</a></p>
</body>
</html>

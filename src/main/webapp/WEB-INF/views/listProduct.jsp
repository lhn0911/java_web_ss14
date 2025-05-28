<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/28/2025
  Time: 10:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh sách đơn hàng</h2>

<a href="${pageContext.request.contextPath}/orders/addOrder">Thêm đơn hàng mới</a><br><br>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>Mã đơn hàng</th>
        <th>Tên sản phẩm</th>
        <th>Số lượng</th>
        <th>Thao tác</th>
    </tr>
    <c:forEach var="order" items="${orders}">
    <tr>
        <td>${order.id}</td>
        <td>${order.productName}</td>
        <td>${order.quantity}</td>
        <td>
            <a href="${pageContext.request.contextPath}/orders/editOrder/${order.id}">Sửa</a> |
            <a href="${pageContext.request.contextPath}/orders/deleteOrder/${order.id}" onclick="return confirm('Bạn có chắc muốn xóa?')">Xóa</a>
        </td>
    </tr>
    </c:forEach>
</body>
</html>

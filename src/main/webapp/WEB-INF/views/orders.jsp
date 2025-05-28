<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/29/2025
  Time: 12:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách đơn hàng</title>
</head>
<body>
<h2>Danh sách đơn hàng</h2>
<a href="${pageContext.request.contextPath}/addOrder">Thêm đơn hàng mới</a>
<table border="1" cellpadding="5" cellspacing="0">
    <thead>
    <tr>
        <th>Mã đơn hàng</th>
        <th>Tên sản phẩm</th>
        <th>Số lượng</th>
        <th>Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>${order.id}</td>
            <td>${order.productName}</td>
            <td>${order.quantity}</td>
            <td>
                <a href="${pageContext.request.contextPath}/editOrder/${order.id}">Sửa</a> |
                <a href="${pageContext.request.contextPath}/deleteOrder/${order.id}"
                   onclick="return confirm('Bạn có chắc muốn xóa?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${empty orders}">
        <tr><td colspan="4">Chưa có đơn hàng nào.</td></tr>
    </c:if>
    </tbody>
</table>
</body>
</html>
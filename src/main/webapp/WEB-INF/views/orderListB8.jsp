<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/29/2025
  Time: 1:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh sách đơn hàng đã đặt</h2>

<table border="1">
    <tr><th>Tên người dùng</th><th>Sản phẩm</th><th>Số lượng</th></tr>
    <c:forEach var="order" items="${ordersB8}">
        <tr>
            <td>${order.username}</td>
            <td>${order.product}</td>
            <td>${order.quantity}</td>
        </tr>
    </c:forEach>
</table>

<p><a href="${pageContext.request.contextPath}/orderB8">Quay lại đặt hàng</a></p>
</body>
</html>

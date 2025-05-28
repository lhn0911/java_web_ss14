<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/28/2025
  Time: 11:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh sách sản phẩm trong giỏ</h2>
<c:if test="${empty cart}">
    <p>Giỏ hàng trống.</p>
</c:if>
<c:if test="${not empty cart}">
    <table border="1">
        <tr><th>Tên</th><th>Số lượng</th><th>Thao tác</th></tr>
        <c:forEach var="p" items="${cart}">
            <tr>
                <td>${p.name}</td>
                <td>${p.quantity}</td>
                <td><a href="/remove?id=${p.id}">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<a href="/form">Quay lại</a>
</body>
</html>

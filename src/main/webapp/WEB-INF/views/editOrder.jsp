<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/29/2025
  Time: 12:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa đơn hàng</title>
</head>
<body>
<h2>Sửa đơn hàng</h2>
<form:form method="post" modelAttribute="order" action="${pageContext.request.contextPath}/editOrder">
    <table>
        <tr>
            <td>Mã đơn hàng:</td>
            <td><form:input path="id" readonly="true"/></td>
        </tr>
        <tr>
            <td>Tên sản phẩm:</td>
            <td><form:input path="productName" /></td>
        </tr>
        <tr>
            <td>Số lượng:</td>
            <td><form:input path="quantity" type="number" min="1"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Cập nhật" /></td>
        </tr>
    </table>
</form:form>
<a href="${pageContext.request.contextPath}/order">Quay lại danh sách</a>
</body>
</html>
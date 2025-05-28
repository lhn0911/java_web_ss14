<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/28/2025
  Time: 11:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Thêm sản phẩm vào giỏ</h2>
<form:form action="/add" method="post" modelAttribute="product">
    ID: <form:input path="id"/><br/>
    Tên: <form:input path="name"/><br/>
    Giá: <form:input path="price"/><br/>
    Số lượng: <form:input path="quantity"/><br/>
    <input type="submit" value="Thêm vào giỏ"/>
</form:form>


<h3>Sản phẩm đã lưu trong cookie:</h3>
<ul>
    <c:forEach items="${savedProducts}" var="p">
        <li>${p}</li>
    </c:forEach>
</ul>

<a href="/cart">Xem giỏ hàng</a>
</body>
</html>

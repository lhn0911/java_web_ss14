<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/29/2025
  Time: 1:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2><spring:message code="register.title"/></h2>

<form:form action="${pageContext.request.contextPath}/register" method="post" modelAttribute="userDTO">
    <label><spring:message code="label.username"/></label><br>
    <form:input path="username"/>
    <form:errors path="username" cssClass="error"/><br>

    <label><spring:message code="label.password"/></label><br>
    <form:password path="password"/>
    <form:errors path="password" cssClass="error"/><br>

    <label><spring:message code="label.confirmPassword"/></label><br>
    <form:password path="confirmPassword"/>
    <form:errors path="confirmPassword" cssClass="error"/><br>

    <label><spring:message code="label.email"/></label><br>
    <form:input path="email"/>
    <form:errors path="email" cssClass="error"/><br><br>

    <button type="submit"><spring:message code="button.register"/></button>
</form:form>


<a href="?lang=vi">Tiếng Việt</a> | <a href="?lang=en">English</a>
</body>
</html>

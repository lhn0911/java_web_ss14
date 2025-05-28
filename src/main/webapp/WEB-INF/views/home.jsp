<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/28/2025
  Time: 11:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><spring:message code="welcome" /></h1>
<p><spring:message code="instruction" /></p>

<form action="" method="get">
    <select name="lang" onchange="this.form.submit()">
        <option value="vi" ${cookie.lang.value == 'vi' ? 'selected' : ''}>Tiếng Việt</option>
        <option value="en" ${cookie.lang.value == 'en' ? 'selected' : ''}>English</option>
    </select>
</form>
</body>
</html>

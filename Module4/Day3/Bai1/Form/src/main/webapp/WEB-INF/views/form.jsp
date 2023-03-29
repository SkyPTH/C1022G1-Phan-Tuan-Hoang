<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: H
  Date: 3/29/2023
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Setting</h2>
<form:form action="/mail-setting/create" method="post" modelAttribute="mailSetting">
    <label for="language">Languages</label>
    <form:select id="language" path="language">
        <form:options items="${language}"></form:options>
    </form:select>
    <label for="pageSize">Languages</label>
    <form:select id="pageSize" path="pageSize">
        <form:options items="${pageSize}"></form:options>
    </form:select>
    <form:checkbox path="spamFilter" value="true"></form:checkbox>
    <form:input path="signature"></form:input>
</form:form>
</body>
</html>

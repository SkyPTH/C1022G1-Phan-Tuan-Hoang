<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: H
  Date: 3/29/2023
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form:form cssClass="form-control" modelAttribute="mailSetting" action="/mail-setting/update" method="post">
<div class="mb-3">
    <label for="language">Languages</label>
    <form:select id="language" path="language">
        <form:options items="${language}"></form:options>
    </form:select>
    <div class="mb-3">
        <label for="pageSize">Languages</label>
        <form:select id="pageSize" path="pageSize">
            <form:options items="${pageSize}"></form:options>
        </form:select>
    </div>
    <div class="mb-3">
        <label for="spamFilter">Enable spam filter</label><form:checkbox path="spamFilter" value="true"
                                                                         id="spamFilter"></form:checkbox>
    </div>
    <div class="mb-3">
        <label for="signature"></label><form:input path="signature" id="signature"></form:input></div>
    <input type="submit" value="Save">
    </form:form>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: H
  Date: 3/29/2023
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List mail setting</title>
    <link rel="stylesheet" href="../../bootstrap-5.0.2-dist/bootstrap-5.0.2-dist/css/bootstrap.css">
</head>
<body>
<table border="solid 1px" class="border-5">
    <tr class="bg-primary ">
        <th>Language</th>
        <th>Page size</th>
        <th>Spam Filter</th>
        <th>Signature</th>
    </tr>
    <c:forEach items="${list}" var="mail">
    <tr class="text-center">
        <th>${mail.language}</th>
        <th>${mail.pageSize}</th>
        <th>${mail.spamFilter}</th>
        <th>${mail.signature}</th>
    </tr>
    </c:forEach>
</table>
<a class="bg-primary text-danger" href="/mail-setting/create">Create</a>
<a  class="bg-primary text-danger" href="/mail-setting/update">Update</a>
<h2>${message}</h2>
</body>
</html>

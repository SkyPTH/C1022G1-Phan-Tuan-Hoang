<%--
  Created by IntelliJ IDEA.
  User: H
  Date: 3/27/2023
  Time: 2:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/home" method="get">
    <input name="usd" type="number" value="${usd}" placeholder="Input usd number">
    <input type="submit" value="Change">
</form>
<h1>${result} VND</h1>
</body>
</html>

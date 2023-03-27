<%--
  Created by IntelliJ IDEA.
  User: H
  Date: 3/22/2023
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <label for="bookName">Book name</label>
    <input type="text" name="bookName" id="bookName">
    <label for="pageSize">Page Size</label>
    <input type="text" name="pageSize" id="pageSize">

    <select name="categoryID">
        <c:forEach items="${categoryList}" var="category">
            <option value="${category.categoryID}">${category.categoryName}</option>
<%--            <option value="${category.categoryID}">${category.categoryName}</option>--%>
        </c:forEach>
    </select>
    <button type="submit">Submit</button>
</form>
</body>
</html>

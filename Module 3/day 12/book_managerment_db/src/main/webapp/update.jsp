<%--
  Created by IntelliJ IDEA.
  User: H
  Date: 3/8/2023
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="post" role="form">
    <div class="form-group">
        <label for="id"></label>
        <input type="hidden" class="form-control" name="id" id="id" placeholder="Input id" value="${book.id}">
        <label for="name"></label>
        <input type="text" class="form-control" name="name" id="name" placeholder="Input name" value="${book.name}">
        <label for="pageSize"></label>
        <input type="text" class="form-control" name="pageSize" id="pageSize" placeholder="Input page size"
               value="${book.pageSize}">
        <select name="authorID"><c:forEach items="${authorList}" var="author">
            <c:if test="${author.authorID == book.author.authorID}">
                <option value="${author.authorID}" selected>${author.authorName}</option>
            </c:if>
            <c:if test="${author.authorID != book.author.authorID}">
                <option value="${author.authorID}">${author.authorName}</option>
            </c:if>
        </c:forEach> </select>
        <select name="categoryID"><c:forEach items="${categoryList}" var="category">
            <c:if test="${category.categoryID==book.category.categoryID}">
                <option value="${category.categoryID}" selected>${category.categoryName}</option>
            </c:if>
            <c:if test="${category.categoryID!=book.category.categoryID}">
                <option value="${category.categoryID}">${category.categoryName}</option>
            </c:if>
        </c:forEach> </select>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>

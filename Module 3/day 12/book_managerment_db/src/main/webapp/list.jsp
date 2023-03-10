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
    <title>Display List</title>
    <link rel="stylesheet" href="/WEB-INF/bootstrap-5.2.3-dist/css/bootstrap.css">
</head>
<body>
<div><a href="/book?action=create">Create</a></div>
<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>PageSize</th>
        <th>Author</th>
        <th>Category</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${bookList}">
    <tr>
        <td scope="row"> ${book.id}</td>
        <td>${book.name}</td>
        <td>${book.pageSize}</td>
        <td>${book.author.authorName}</td>
        <td>${book.category.categoryName}</td>
        <td><a type="button" href="/book?action=update&id=${book.id}">Update</a></td>
        <td><a type="button" href="/book?action=delete&id=${book.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </tbody>
</table>

<script src="WEB-INF/bootstrap-5.2.3-dist/js/bootstrap.js"></script>
</body>
</html>

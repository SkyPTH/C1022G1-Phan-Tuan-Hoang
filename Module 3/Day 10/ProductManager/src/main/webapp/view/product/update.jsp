<%--
  Created by IntelliJ IDEA.
  User: H
  Date: 2/14/2023
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <link rel="stylesheet" href="/bootstrap-5.0.2-dist/bootstrap-5.0.2-dist/css/bootstrap.css">
</head>
<body>
<form action="" method="post">
    <label for="name">Name</label>
    <input type="text" class="form-control" name="name" id="name" value="${product.name}">

    <label for="price">Price</label>
    <input type="number" class="form-control" name="price" id="price" value="${product.price}">

    <label for="description">Description</label>
    <input type="text" class="form-control" name="description" id="description" value="${product.description}">

    <label for="producer">Producer</label>
    <input type="text" class="form-control" name="producer" id="producer" value="${product.producer}">
    <input type="submit" value="Cập nhật">
</form>
<script src="/bootstrap-5.0.2-dist/bootstrap-5.0.2-dist/js/bootstrap.bundle.js"></script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: H
  Date: 2/14/2023
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
    <link rel="stylesheet" href="/bootstrap-5.0.2-dist/bootstrap-5.0.2-dist/css/bootstrap.css">
</head>
<body>
<form action="" method="post">
    <h1>Xóa sản phẩm ${product.name}</h1>
    <table class="table">
        <tr>
            <th>Name</th>
            <td>${product.name}</td>
        </tr>
        <tr>
            <th>Price</th>
            <td>${product.price}</td>
        </tr>
        <tr>
            <th>Description</th>
            <td>${product.description}</td>
        </tr>
        <tr>
            <th>Producer</th>
            <td>${product.producer}</td>
        </tr>
    </table>
    <input type="submit" value="Xóa">
</form>
</body>
</html>

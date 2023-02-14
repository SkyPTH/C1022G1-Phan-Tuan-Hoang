<%--
  Created by IntelliJ IDEA.
  User: H
  Date: 2/13/2023
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Display List</title>
    <link rel="stylesheet" href="/bootstrap-5.0.2-dist/bootstrap-5.0.2-dist/css/bootstrap.css">
</head>
<body>

<table class="table">
    <thead>
    <tr class="row">
        <th class="col-1"> Name</th>
        <th class="col-1"> Price</th>
        <th class="col-1"> Description</th>
        <th class="col-1"> Producer</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach varStatus="loop" items="${productList}" var="product">
        <tr class="row">
            <td class="col-1">${product.name} </td>
            <td class="col-1">${product.price}</td>
            <td class="col-1">${product.description}</td>
            <td class="col-1">${product.producer}</td>
            <td><a class="btn btn-primary col-1 " href="/product?action=update&id=${products.id}">update</a></td>
            <td><a class="btn btn-danger col-1 " href="/product?action=delete&id=${products.id}">delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>

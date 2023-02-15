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
    <tr class="">
        <th class=""> Name</th>
        <th class=""> Price</th>
        <th class=""> Description</th>
        <th class=""> Producer</th>
        <th> </th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach varStatus="loop" items="${productList}" var="product">
        <tr class="">
            <td class="">${product.name} </td>
            <td class="">${product.price}</td>
            <td class="">${product.description}</td>
            <td class="">${product.producer}</td>
            <td><a class="btn btn-primary  " href="/product?action=update&id=${product.id}">update</a></td>
            <td><a class="btn btn-danger  " href="/product?action=delete&id=${product.id}">delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>

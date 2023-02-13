<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Manager</title>

</head>
<body>
<table class="table">
    <thead>
    <tr class="row">
        <th class="col-3"> Name</th>
        <th class="col-3"> Price</th>
        <th class="col-3"> Description</th>
        <th class="col-3"> Producer</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach varStatus="loop" items="${productList}" var="product">
        <tr class="row">
            <td class="col-3">${product.name} </td>
            <td class="col-3">${product.price}</td>
            <td class="col-3">${product.description}</td>
            <td class="col-3">${product.producer}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
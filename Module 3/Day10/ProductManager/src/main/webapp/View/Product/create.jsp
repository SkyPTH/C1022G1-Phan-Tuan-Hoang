<%--
  Created by IntelliJ IDEA.
  User: H
  Date: 2/13/2023
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create</title>
    <link rel="stylesheet" href="/bootstrap-5.0.2-dist/bootstrap-5.0.2-dist/css/bootstrap.css">
</head>
<body>
<div class="container">
    <form method="post">
    <div class="form-group">
        <label for="name"></label>
        <input type="text" name="name" id="name" class="form-control" >
    </div>
        <div class="form-group">
            <label for="price"></label>
            <input type="text" name="price" id="price" class="form-control" >
        </div>
        <div class="form-group">
            <label for="description"></label>
            <input type="text" name="description" id="description" class="form-control" >
        </div>
        <div class="form-group">
            <label for="producer"></label>
            <input type="text" name="producer" id="producer" class="form-control" >
        </div>
    </form>
</div>
<script src="/bootstrap-5.0.2-dist/bootstrap-5.0.2-dist/js/bootstrap.bundle.js"></script>
</body>
</html>

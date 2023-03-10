<%--
  Created by IntelliJ IDEA.
  User: H
  Date: 3/6/2023
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="">
<div class="form-group">
    <label for="tittle">Tittle</label>
    <input type="text" name="tittle" id="tittle" class="form-control" placeholder="tittle" aria-describedby="helpId">
</div>
<div class="form-group">
    <label for="pageSize">Page Size</label>
    <input type="text" name="pageSize" id="pageSize" class="form-control" placeholder="Page Size" aria-describedby="helpId">
</div>
<div class="form-group">
    <label for="author">Author</label>
    <input type="text" name="author" id="author" class="form-control" placeholder="Author" aria-describedby="helpId">
</div>
<div class="form-group">
    <label for="category">Category</label>
    <input type="text" name="category" id="category" class="form-control" placeholder="" aria-describedby="helpId">
</div>
    <div><input type="submit" value="Submit"> </div>
</form>
</body>
</html>

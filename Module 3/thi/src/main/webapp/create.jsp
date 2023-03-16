<%--
  Created by IntelliJ IDEA.
  User: H
  Date: 3/14/2023
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<form action="" method="post" role="form">
    <div class="form-group">
        <label for="bookName">Book name</label>
        <input type="text" class="form-control" name="bookName" id="bookName" placeholder="Input...">
    </div>
    <div class="form-group">
        <label for="pageSize">Page size</label>
        <input type="text" class="form-control" name="pageSize" id="pageSize" placeholder="Input...">
    </div>
    <div class="form-group">
        <label for="bookName">Book name</label>
        <select name="categoryID">
            <c:forEach items="${categoryList}" var="category" >
                <option value="${category.categoryID}">${category.categoryName}</option>
            </c:forEach>
        </select>
    </div>



    <button type="submit" class="btn btn-primary">Submit</button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
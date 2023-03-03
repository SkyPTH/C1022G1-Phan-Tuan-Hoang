<%--
  Created by IntelliJ IDEA.
  User: H
  Date: 3/2/2023
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>12312312313123123</title>
</head>
<body>
<div>
    <form action="" method="post">
        <div class="form-group">
            <label for="id">Nhập ID</label>
            <input type="text" name="id" id="id" class="form-control" placeholder="Nhập id vào đây"
                   aria-describedby="helpId">
        </div>
        <div class="form-group">
            <label for="pass">Nhập Password</label>
            <input type="text" name="pass" id="pass" class="form-control" placeholder="Nhập pass vào đây"
                   aria-describedby="helpId">
        </div>
        <button type="submit" >Submit</button>
    </form>
    <c:if test="${not empty correct}">
        <p>${correct}</p>
    </c:if>
</div>
</body>
</html>

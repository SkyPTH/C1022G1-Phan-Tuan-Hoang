<%--
  Created by IntelliJ IDEA.
  User: H
  Date: 3/27/2023
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/dictionary" method="post" role="form">
    <div class="form-group">
        <input type="text" class="form-control" name="word" id="word">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<h1>${result}</h1>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: H
  Date: 3/28/2023
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="/food">
  <label for="lettuce">Lettuce</label>
  <input type="checkbox" name="condiment" value="lettuce" id="lettuce">
  <br>
  <label for="tomato">Tomato</label>
  <input type="checkbox" name="condiment" value="tomato" id="tomato">
  <br>
  <label for="mustard">Mustard</label>
  <input type="checkbox" name="condiment" value="mustard" id="mustard">
  <br>
  <label for="sprouts">Sprouts</label>
  <input type="checkbox" name="condiment" value="sprouts" id="sprouts">
  <br>
  <input type="submit" value="Save">
</form>
<div>${condiment}</div>

</body>
</html>

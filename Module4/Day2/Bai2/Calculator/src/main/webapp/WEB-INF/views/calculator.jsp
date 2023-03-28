<%--
  Created by IntelliJ IDEA.
  User: H
  Date: 3/28/2023
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="/calculator">
    <label for="firstNum">Fist number</label>
    <input type="number" name="firstNum"  id="firstNum">
    <br>
    <label for="secondNum">Second number</label>
    <input type="number" name="secondNum"  id="secondNum">
    <br>
</form>
<input type="submit" name="operand" value="Addition(+)">
<input type="submit" name="operand" value="Subtraction(-)">
<input type="submit" name="operand" value="Multiplication(*)">
<input type="submit" name="operand" value="Division(/)">
</body>
</html>

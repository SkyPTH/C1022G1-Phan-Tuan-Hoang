<%--
  Created by IntelliJ IDEA.
  User: H
  Date: 3/8/2023
  Time: 2:32 PM
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
    <table class="table" border="1px solid">
        <tbody>
        <tr>
            <td scope="row"><label for="name">Name</label><input type="text" name="name" id="name"></td>
            <td><label for="pageSize">Page Size</label><input type="text" name="pageSize" id="pageSize"></td>
            <td><select name="authorID"><c:forEach var="author" items="${authorList}"><option  value="${author.authorID}">${author.authorName}</option> </c:forEach></select></td>
            <td><select name="categoryID"><c:forEach var="category" items="${categoryList}"><option  value="${category.categoryID}">${category.categoryName}</option> </c:forEach></select></td>            <td>
                <button type="submit">Submit</button>
            </td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>

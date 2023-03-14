<%--
  Created by IntelliJ IDEA.
  User: H
  Date: 3/8/2023
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Display List</title>
    <link rel="stylesheet" href="/WEB-INF/bootstrap-5.2.3-dist/css/bootstrap.css">
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div><a href="/book?action=create">Create</a></div>
<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>PageSize</th>
        <th>Author</th>
        <th>Category</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${bookList}">
        <tr>
            <td scope="row"> ${book.id}</td>
            <td>${book.name}</td>
            <td>${book.pageSize}</td>
            <td>${book.author.authorName}</td>
            <td>${book.category.categoryName}</td>
            <td><a type="button" href="/book?action=update&id=${book.id}">Update</a></td>
            <td>
                <button type="button" onclick="deleteID(${book.id})" class="btn btn-danger btn-lg"
                        data-bs-toggle="modal" data-bs-target="#modelId">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="modelId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="modelTitleId"></h4>
                <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure to delete this book?
            </div>
            <div class="modal-footer">
                <form action="/book">
                    <input type="hidden" id="id" name="id">
                    <input type="hidden"  name="action" value="delete">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </form>
            </div>

        </div>
    </div>
</div>
<script src="WEB-INF/bootstrap-5.2.3-dist/js/bootstrap.js">


</script>
<script>
    function deleteID(id) {
        document.getElementById("id").value = id;
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>

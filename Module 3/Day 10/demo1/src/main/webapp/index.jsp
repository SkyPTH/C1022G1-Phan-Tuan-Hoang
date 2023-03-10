<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Display List</title>
</head>
<body>
<h2> Hiển thị danh sách khách hàng </h2>
<table>
<tr>
    <th>ID</th>
    <th>Tên</th>
    <th>Giới tính</th>
    <th>Điểm</th>
    <th>Xếp loại</th>
</tr>
    <c:forEach var="student" items="${studentList}" >
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.gender}</td>
            <td>${student.score}</td>
            <td>
                <c:if test="${student.score>=90}">Giỏi</c:if>
                <c:if test="${student.score>=80 && student.score<90}">Khá</c:if>
                <c:if test="${student.score>=60&& student.score<80}">Trung bình</c:if>
                <c:if test="${student.score<60}" >Yếu</c:if>
            </td>
        </tr>
    </c:forEach>
</table>
<p >${emptyList}</p>
</body>
</html>
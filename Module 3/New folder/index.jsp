<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title> asdasdad</title>
    <link rel="stylesheet" href='bootstrap-5.0.2-dist/bootstrap-5.0.2-dist/css/bootstrap.css'>
</head>
<body>
<h1>Product Discount Calculator</h1>
<form action="/Calculator" method="get">
    <table>
        <tr>
            <td>
                <label for="product-description"> Product Description </label>
            </td>
            <td>
                <input type="text" name="product-description" id="product-description">
            </td>
        </tr>
        <tr>
            <td>
                <label for="list-price"> List Price </label></td>
            <td>
                <input type="text" name="list-price" id="list-price">
            </td>
        </tr>
        <tr>
            <td>
                <label for="discount-percent"> Discount Percent </label>
            </td>
            <td>
                <input type="text" name="discount-percent" id="discount-percent">
            </td>
        </tr>
        <tr>
            <td> <button type="submit"> Submit </button></td>
        </tr>
    </table>
</form>
<script src="bootstrap-5.0.2-dist/bootstrap-5.0.2-dist/js/bootstrap.bundle.js"></script>
</body>

</html>
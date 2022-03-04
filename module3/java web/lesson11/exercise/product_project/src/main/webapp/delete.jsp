<%--
  Created by IntelliJ IDEA.
  User: nguyenhoang
  Date: 2/14/22
  Time: 4:47 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div align="center">
        <h2>Delete product</h2>
        <form action="/?action=delete" method="post">
            <table>
                <tr>
                    <td>id</td>
                    <td><input type="text" readonly value="${product.id}" name="id"></td>
                </tr>
                <tr>
                    <td>name</td>
                    <td><input type="text" readonly value="${product.name}"></td>
                </tr>
                <tr>
                    <td>price</td>
                    <td><input type="text" readonly value="${product.price}"></td>
                </tr>
                <tr>
                    <td>producer</td>
                    <td><input type="text" readonly value="${product.producer}"></td>
                </tr>
            </table>
            <br>
            <input type="submit" name="Are you sure" style="background: red;color: white;padding: 5px;">
        </form>
    </div>
</body>
</html>

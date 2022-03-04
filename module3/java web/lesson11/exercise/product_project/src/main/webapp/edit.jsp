<%--
  Created by IntelliJ IDEA.
  User: nguyenhoang
  Date: 2/14/22
  Time: 4:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h2>Edit customer</h2>
    <form action="/?action=edit" method="post">
        <table>
            <tr>
                <th>id</th>
                <th><input type="text" readonly name="id" value="${product.id}"></th>
            </tr>
            <tr>
                <th>Name</th>
                <td><input type="text" name="name" placeholder="input name" value="${product.name}"></td>
            </tr>
            <tr>
                <th>Price</th>
                <td><input type="text" name="price" placeholder="input price" value="${product.price}"></td>
            </tr>
            <tr>
                <th>Producer</th>
                <td><input type="text" name="producer" placeholder="input producer" value="${product.producer}"></td>
            </tr>
        </table>
        <input type="submit" value ="UPDATE" style="background: green; padding: 5px; color: white">
    </form>
</div>
</body>
</html>

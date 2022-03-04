<%--
  Created by IntelliJ IDEA.
  User: nguyenhoang
  Date: 2/14/22
  Time: 1:57 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <title>Title</title>
    <style>
        table,tr,td,th{
            border: 1px solid black;
        }
        table{
            width: 50%;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
    <div align="center">
        <h2>list product</h2>
        <form action="?action=search" method="post">
            <input type="text" name="search" placeholder="input name">
            <input type="submit" value="Search" style="background: green;color: white; padding: 5px">
        </form>
        <table >
            <tr>
                <th>id</th>
                <th>name</th>
                <th>price</th>
                <th>producer</th>
                <th>action</th>
            </tr>
            <c:forEach var="product" items="${productList}">
                <tr>
                    <td>${product.id}</td>
                    <td>
                       <a href="/?action=seeDetail&id=${product.id}">
                            ${product.name}
                       </a>
                    </td>

                    <td>${product.price}</td>
                    <td>${product.producer}</td>
                    <td>
                        <a href="/?action=edit&id=${product.id}"><i class="material-icons">edit</i></a>
                        <a href="/?action=delete&id=${product.id}"><i class="material-icons" style="color: red">delete_forever</i></a>

                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <br>
        <a href="/?action=create" style="background: green;color: white; padding: 5px">ADD</a>
    </div>
  <h2></h2>
</body>
</html>

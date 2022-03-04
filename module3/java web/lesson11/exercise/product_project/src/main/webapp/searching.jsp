<%--
  Created by IntelliJ IDEA.
  User: nguyenhoang
  Date: 2/14/22
  Time: 7:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
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
        <h2>List product has name is ${name}</h2>
        <c:choose>
            <c:when test="${size==0}">
                <pq>not data</pq>
            </c:when>
            <c:otherwise>
                <table>
                    <tr>
                        <th>id</th>
                        <th>name</th>
                        <th>price</th>
                        <th>producer</th>
                    </tr>
                    <c:forEach var="product" items="${listProduct}">
                        <tr>
                            <td>${product.id}</td>
                            <td>${product.name}</td>
                            <td>${product.price}</td>
                            <td>${product.producer}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>

        <br>
        <a href="/">return to list all products</a>
    </div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: nguyenhoang
  Date: 2/15/22
  Time: 11:39 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>List users has country is ${country}</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
    </table>
    <c:choose>
        <c:when test="${size==0}">
            <tr>
                not data
            </tr>
        </c:when>
        <c:o></c:o>
    </c:choose>
   <div align="center">
       <h2>List </h2>
   </div>
</body>
</html>

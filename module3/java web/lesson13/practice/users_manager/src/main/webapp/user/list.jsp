<%--
  Created by IntelliJ IDEA.
  User: nguyenhoang
  Date: 2/10/22
  Time: 9:38 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet" href="http://cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/UserServlet?action=create">Add New User</a>
    </h2>
    <br>
    <form action="UserServlet?action=search" method="post">
        <input type="text" name="country" placeholder="input country">
        <br>
        <br>
        <input type="text" name = id placeholder="input id">
        <br>
        <br>
        <input type="submit" value="Search">
    </form>
    <br>
    <a href="/UserServlet" style="display: inline-block; background: green; color: white; padding: 5px">All list user</a>
</center>
<div align="center">
    <table border="1" cellpadding="5" id="1example" class="hover" style="width:100%">
        <caption><h2>List of Users</h2></caption>
        <thead>
        <tr style="background: gray;color: white">
            <th>ID</th>
            <th><a href="UserServlet?action=sort">Name</a></th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/UserServlet?action=edit&id=${user.id}">Edit</a>
                    <a href="/UserServlet?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
<script>
    $(document).ready(function() {
        $('#example').DataTable();
    } );
</script>
</body>
</html>

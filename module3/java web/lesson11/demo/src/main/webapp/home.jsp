<%--
  Created by IntelliJ IDEA.
  User: nguyenhoang
  Date: 2/7/22
  Time: 12:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%--  <a href="delete?id=4">deleteaction</a>--%>
  <h2 style="text-align: center">Customer manager</h2>
  <h2 style="text-align: center">
    <a href="/create">Add customer</a>
    <a href="">Display</a>
  </h2>
  <div align="center">
    <table>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Action</th>
      </tr>
      <c:forEach var="customer" items="${listCustomer}">
        <tr>
          <td>${customer.id}</td>
          <td>${customer.name}</td>
          <td>${customer.phone}</td>
          <td>${customer.email}</td>
          <td>
            <a href="/edit?id=${customer.id}">edit</a>
            <a href="/delete?id=${customer.id}">delete</a></td>
        </tr>
      </c:forEach>
    </table>
  </div>

  </body>
</html>

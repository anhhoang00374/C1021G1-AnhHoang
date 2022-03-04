<%--
  Created by IntelliJ IDEA.
  User: nguyenhoang
  Date: 2/8/22
  Time: 6:59 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2 style="text-align: center"><a href="/customers?action=create">Create new Customer</a></h2>
  <div align="center">
    <table>
      <tr>
        <th>id</th>
        <th>name</th>
        <th>email</th>
        <th>address</th>
        <th>action</th>
      </tr>
      <c:forEach var="customer" items="${customers}">
        <tr>
          <td>${customer.id}</td>
          <td>${customer.name}</td>
          <td>${customer.email}</td>
          <td>${customer.address}</td>
          <td>
            <a href="/customers?action=edit&id=${customer.getId()}">edit</a>
            <a href="/customers?action=delete&id=${customer.getId()}">delete</a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </div>

  </body>
</html>

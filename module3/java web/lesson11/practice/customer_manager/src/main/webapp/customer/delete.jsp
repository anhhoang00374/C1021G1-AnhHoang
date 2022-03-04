<%--
  Created by IntelliJ IDEA.
  User: nguyenhoang
  Date: 2/8/22
  Time: 9:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Deleting customer</title>
</head>
<body>
<h1 style="text-align: center">Delete customer</h1>
<p style="text-align: center">
  <a href="/customers"> Back to customer list</a>
</p>
<div align="center">
  <form method="post" action="/customers?action=delete&id=${customer.id}" style="width: 50%">
    <h3>Are you sure?</h3>
    <fieldset>
      <legend>Customer information</legend>
      <table>
        <tr>
          <td>Name: </td>
          <td>${customer.getName()}</td>
        </tr>
        <tr>
          <td>Email: </td>
          <td>${customer.getEmail()}</td>
        </tr>
        <tr>
          <td>Address: </td>
          <td>${customer.getAddress()}</td>
        </tr>
        <tr>
          <td><input type="submit" value="Delete customer"></td>
        </tr>
      </table>
    </fieldset>
  </form>
</div>

</body>
</html>

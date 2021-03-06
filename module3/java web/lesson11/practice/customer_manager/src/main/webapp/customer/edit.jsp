<%--
  Created by IntelliJ IDEA.
  User: nguyenhoang
  Date: 2/8/22
  Time: 9:37 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Edit customer</title>
</head>
<body>
<h1 style="text-align: center">Edit customer</h1>
<p style="text-align: center">
  <c:if test='${requestScope["message"] != null}'>
    <span class="message">${requestScope["message"]}</span>
  </c:if>
</p>
<p style="text-align: center">
  <a href="/customers">Back to customer list</a>
</p>
<div align="center">
  <form method="post" style="width: 50%">
    <fieldset>
      <legend>Customer information</legend>
      <table>
        <tr>
          <td>Name: </td>
          <td><input type="text" name="name" id="name" value="${requestScope["customer"].getName()}"></td>
        </tr>
        <tr>
          <td>Email: </td>
          <td><input type="text" name="email" id="email" value="${requestScope["customer"].getEmail()}"></td>
        </tr>
        <tr>
          <td>Address: </td>
          <td><input type="text" name="address" id="address" value="${requestScope["customer"].getAddress()}"></td>
        </tr>
        <tr>
          <td></td>
          <td><input type="submit" value="Update customer"></td>
        </tr>
      </table>
    </fieldset>
  </form>
</div>
</body>
</html>

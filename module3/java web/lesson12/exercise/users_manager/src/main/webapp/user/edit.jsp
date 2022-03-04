<%--
  Created by IntelliJ IDEA.
  User: nguyenhoang
  Date: 2/11/22
  Time: 10:23 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Edit customer</title>
</head>
<body>
<h1>Edit customer</h1>
<p>
  <c:if test='${requestScope["message"] != null}'>
    <span class="message">${requestScope["message"]}</span>
  </c:if>
</p>
<p>
  <a href="/UserServlet">Back to customer list</a>
</p>
<form method="post" action="/UserServlet?action=edit">
  <fieldset>
    <legend>Customer information</legend>
    <table>
      <tr>
        <td></td>
        <td><input type="hidden" name="id" value="${requestScope["user"].getId()}"></td>
      </tr>
      <tr>
        <td>Name: </td>
        <td><input type="text" name="name" id="name" value="${requestScope["user"].getName()}"></td>
      </tr>
      <tr>
        <td>Email: </td>
        <td><input type="text" name="email" id="email" value="${requestScope["user"].getEmail()}"></td>
      </tr>
      <tr>
        <td>Address: </td>
        <td><input type="text" name="country" id="address" value="${requestScope["user"].getCountry()}"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Update customer"></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>

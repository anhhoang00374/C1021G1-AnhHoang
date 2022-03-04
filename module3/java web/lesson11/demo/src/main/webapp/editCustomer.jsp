<%--
  Created by IntelliJ IDEA.
  User: nguyenhoang
  Date: 2/8/22
  Time: 6:00 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 style="text-align: center">Edit Customer</h2>
<div align = "center">
    <form action="update" method="get">
        <table>
            <tr>
                <td>
                    <input type="hidden" name="id" value="${customer.id}">
                </td>
            </tr>
            <tr>
                <td>name</td>
                <td>
                    <input type="text" name="name" value="${customer.name}">
                </td>
            </tr>
            <tr>
                <td>phone</td>
                <td>
                    <input type="text" name="phone" value="${customer.phone}">
                </td>
            </tr>
            <tr>
                <td>email</td>
                <td>
                    <input type="text" name="email" value="${customer.email}">
                </td>
            </tr>
            <tr><input type="submit" value="update"></tr>
        </table>
    </form>
</div>
</body>
</html>

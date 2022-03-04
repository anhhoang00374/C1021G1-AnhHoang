<%--
  Created by IntelliJ IDEA.
  User: nguyenhoang
  Date: 2/28/22
  Time: 8:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Calculator</h2>
  <form action="calculate" method="post">
    <input type="text" name="num1" placeholder="number one"><br>
    <br><input name="num2" type="text" placeholder="number second"><br><br>
    <input type="submit" name="operator" value="Add">
    <input type="submit" name="operator" value="Sub">
    <input type="submit" name="operator" value="Mul">
    <input type="submit" name="operator" value="Div">
  </form>

  <c:choose>
    <c:when test="${message!=null}">
      <p>${message}</p>
    </c:when>
    <c:otherwise>
      <p>${result}</p>
    </c:otherwise>
  </c:choose>
  </body>
</html>

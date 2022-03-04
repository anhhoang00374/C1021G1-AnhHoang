<%--
  Created by IntelliJ IDEA.
  User: nguyenhoang
  Date: 2/28/22
  Time: 6:48 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Sandwich condiments</h2>
  <form action="/save">
    <input type="checkbox" id="lettuce" value="lettuce" name="condiment" >
    <label for="lettuce">Lettuce</label><br>
    <input type="checkbox" id="tomato"  value="tomato" name="condiment">
    <label for="tomato">Lettuce</label><br>
    <input type="checkbox" id="mustard" value="mustard" name="condiment">
    <label for="mustard">Mustard</label><br>
    <input type="checkbox" id="sprouts" value="sprouts" name="condiment">
    <label for="sprouts">Sprouts</label><br>
    <input type="submit" value="Save">
  </form>
  <c:if test="${condiments!=null}">
    <h3>Saved sandwich has</h3>
    <c:forEach items="${condiments}" var="condiment">
      <p>+ ${condiment}</p>
    </c:forEach>
  </c:if>

  </body>
</html>

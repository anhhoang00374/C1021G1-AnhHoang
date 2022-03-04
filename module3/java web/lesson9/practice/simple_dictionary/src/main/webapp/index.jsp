<%--
  Created by IntelliJ IDEA.
  User: nguyenhoang
  Date: 1/25/22
  Time: 10:46 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<head>
  <title>Simple Dictionary</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Vietnamese Dictionary</h2>
<%--<form action="/translate" method="get">--%>
<%--  <input type="text" name="txtSearch" placeholder="Enter your word: "/>--%>
<%--  <input type = "submit" id = "submit" value = "Search"/>--%>
<%--</form>--%>
<form action="/translate" method="get">
  <input type="text" name="txtSearch" placeholder="Enter your word: "/>
  <input type = "submit" id = "submit" value = "Search"/>
</form>
<p>word list what you can search</p>
<ul>
  <li>hello: xin chào</li>
  <li>how : thế nào</li>
  <li>book : quyển vở</li>
  <li>computer : máy tính</li>
</ul>
</body>
</html>

<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: nguyenhoang
  Date: 1/25/22
  Time: 9:46 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>
<%!
    Map<String, String> dic = new HashMap<>();
%>

<%
    dic.put("hello", "Xin chào");
    dic.put("how", "Thế nào");
    dic.put("book", "Quyển vở");
    dic.put("computer", "Máy tính");

    String search = request.getParameter("search");

    String result = dic.get(search);
    if (result != null) {
        out.print("Word: " + search);
        out.print("Result: " + result);
    } else {
        out.print("Not found");
    }

%>

</body>
</html>

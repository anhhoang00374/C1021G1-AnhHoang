<%--
  Created by IntelliJ IDEA.
  User: nguyenhoang
  Date: 2/26/22
  Time: 3:37 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <%--    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">--%>
    <%--    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">--%>
    <title>$Title$</title>
</head>
<body>
<br>
<br>
<div class="container">
    <div class="row">
        <div class="col-6  m-auto" align="center">
            <form action="/search" class="m-auto" method="post">
                <label for="value">Tiếng anh</label><br>
                <input type="text" name="english" id="value" placeholder="nhập từ">
                <br><br>
                <input type="submit" value="Tra">
            </form>
            <br>
            <br>
            <c:if test="${result!=null}">
                <h3>${result}</h3>
            </c:if>
        </div>
    </div>
</div>
<%--<script src="/assert/jquery/jquery-3.5.1.min.js"></script>--%>
<%--<script src="/assert/bootstrap413/js/popper.min.js"></script>--%>
<%--<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>--%>
<%--<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>--%>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

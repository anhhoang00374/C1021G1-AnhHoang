<%--
  Created by IntelliJ IDEA.
  User: nguyenhoang
  Date: 3/2/22
  Time: 2:35 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
<form:form modelAttribute="setting" method="post" action="/change">
    <table>
        <tr>
            <td>${language.title}</td>
            <td></td>
        </tr>
        <tr>
            <td>${language.language}</td>
            <td><form:select path="languages" items="${languages}"/></td>
        </tr>
        <tr>
            <td>${language.pageSize}</td>
            <td>${language.show}<form:select path="sizeList" items="${sizeList}"/>${language.emailsPerPage}</td>
        </tr>
        <tr>
            <td>${language.spamsFilter}</td>
            <td><form:checkbox path="spam"/>${language.enableSpamsFilter}</td>
        </tr>
        <tr>
            <td>${language.signature}</td>
            <td><form:textarea path="sign"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" class="btn btn-secondary" value="${language.upload}">
                <a href="/cancel" class="btn btn-secondary">${language.cancel}</a>
            </td>
        </tr>

    </table>
</form:form>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

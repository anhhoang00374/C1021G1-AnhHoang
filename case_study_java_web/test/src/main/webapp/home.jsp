<%--
  Created by IntelliJ IDEA.
  User: nguyenhoang
  Date: 2/13/22
  Time: 3:05 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <title>Danh Sách Bệnh Án</title>
    <style>
        th {
            color: crimson;
            font-size: 20px;
            background-color: deepskyblue;
        }

        h1, h2 {
            color: darksalmon;
            font-size: 30px;
            background-color: aquamarine;
        }
    </style>
</head>
<body>
<center>
    <h1>Danh Sách Bệnh Án</h1>
</center>
<div align="center">
    <table border="2" cellpadding="5">
        <caption>
            <h2>Hồ Sơ Bệnh Án</h2>
        </caption>
        <tr>
            <th>STT:</th>
            <th>Mã Bệnh Án:</th>
            <th>Mã Bệnh Nhân:</th>
            <th>Tên Bệnh Nhân:</th>
            <th>Ngày Nhập Viện:</th>
            <th>Ngày Ra Viện:</th>
            <th>Lý Do Nhập Viện:</th>
            <th>Tác vụ:</th>
        </tr>
        <c:forEach var="hoSoBenhAn" items="${listHosoBenhan}">
            <tr>
                <td><c:out value="${hoSoBenhAn.idHoSoBenhAn}"/></td>
                <td><c:out value="${hoSoBenhAn.maBenhAn}"/></td>
                <td><c:out value="${hoSoBenhAn.maBenhNhan}"/></td>
                <td><c:out value="${hoSoBenhAn.tenBenhNhan}"/></td>
                <td><c:out value="${hoSoBenhAn.ngayNhapVien}"/></td>
                <td><c:out value="${hoSoBenhAn.ngayRaVien}"/></td>
                <td><c:out value="${hoSoBenhAn.lyDoNhapVien}"/></td>
                <td>
                    <a href="/?action=edit&id=${hoSoBenhAn.maBenhAn}"><i class='fas fa-edit'></i></a>
                    <a href="/hoSoBenhAnServlet?action=delete&id=${hoSoBenhAn.maBenhAn}"><i class="material-icons">delete</i></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

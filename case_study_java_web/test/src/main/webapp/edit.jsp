<%--
  Created by IntelliJ IDEA.
  User: nguyenhoang
  Date: 2/13/22
  Time: 7:15 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <title>Title</title>
</head>
<body>
    <div align="center">
        <h2>Edit</h2><i class="material-icons">delete</i>
        <br>
        <form action="/?action=edit&id=${hosobenhan.maBenhAn}" method="post">
            <table>
                <tr>
                    <td>ma benh an</td>
                    <td>
                        <input type="text" readonly value="${hosobenhan.maBenhAn}" name="mabenhan" style="background: gray">
                    </td>
                </tr>
                <tr>
                    <td>ma benh nhan</td>
                    <td>
                        <input type="text" name = "mabenhnhan" readonly value="${hosobenhan.maBenhNhan}" style="background: gray">
                    </td>
                </tr>
                <tr>
                    <td>ten benh nhan</td>
                    <td>
                        <input type="text" name="tenbenhnhan" value="${hosobenhan.tenBenhNhan}" >
                    </td>
                </tr>
                <tr>
                    <td>ngay nhap vien</td>
                    <td>
                        <input type="text" name = "ngaynhapvien"  value="${hosobenhan.ngayNhapVien}">
                    </td>
                </tr>
                <tr>
                    <td>ngay ra vien</td>
                    <td>
                        <input type="text" name="ngayravien" value="${hosobenhan.ngayRaVien}">
                    </td>
                </tr>
                <tr>
                    <td>ly do nhap vien</td>
                    <td>
                        <input type="text" name="lydonhapvien"  value="${hosobenhan.lyDoNhapVien}">
                    </td>
                </tr>
                <td>
                    <input type="submit" value="update" >
                </td>
            </table>
        </form>
    </div>
</body>
</html>

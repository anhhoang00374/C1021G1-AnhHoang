<%--
  Created by IntelliJ IDEA.
  User: nguyenhoang
  Date: 2/23/22
  Time: 6:32 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="/static/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/datatables/css/dataTables.bootstrap4.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
</head>
<body onload="checkDate()">
    <div align="center">
        <h2>Add new product</h2>
    </div>
    <div class="container">
        <div class="row" >
            <div class="m-auto col-6 d-flex justify-content-center" >
                <form id ="create-form" action="/?${product.id_product!=null?'action=edit':'action=create'} " method="post"  class="was-validated">
                    <div class="form-group">
                        <input type="hidden" placeholder="input name" class="form-control" name="id"  value="${product.id_product}" r>
                    </div>
                    <div class="form-group">
                        <label>Name:</label>
                        <input type="text" placeholder="input name" class="form-control" name="name" required value="${product.name}" r>
                    </div>
                    <div class="form-group">
                        <label >price:</label>
                        <input type="text" placeholder="input price" class="form-control" required value ="${product.price}" name="price" >
                    </div>
                    <div class="form-group">
                        <label for="name">quantity:</label>
                        <input type="text"  title="not number" class="form-control" value="${product.quantity}" id="name" placeholder="input quantity" name="quantity" required>
                        <div class="valid-feedback">hợp lệ</div>
                        <div class="invalid-feedback">Vui lòng nhập vào trường này</div>
                    </div>
                    <div class="form-group">
                        <label>color:</label>
                        <input type="text"  class="form-control" min="2000-01-01" value="${product.color}" id="validationDate" placeholder="chọn color" name="color" required>
                        <div class="valid-feedback">hợp lệ</div>
                        <div class="invalid-feedback">Vui lòng nhập vào trường này</div>
                    </div>
                    <div class="form-group">
                        <label >Discription:</label><br>
                        <input type="text"   class="" id="phone" value="${product.description}" placeholder="" name="description" required>
                        <div class="valid-feedback">hợp lệ</div>
                        <div class="invalid-feedback">Vui lòng nhập vào trường này</div>
                    </div>

                    <label for="sel1">Category:</label>
                    <br>
                    <select class="form-control" id="sel1" name="category">
                        <c:forEach var="category" items="${categoryList}">
                            <option ${product.category_id==category.id?'selected' : ''} value="${category.id}">${category.name}</option>
                        </c:forEach>
                    </select>

                    <br>

                        <button type="submit" id = "add" class="btn btn-primary">Add</button>
                        <a href="/ServletCustomer" type="submit" class="btn btn-danger">Cancel</a>
                </form>
            </div>
        </div>
    </div>
    <script>
        function checkDate(){
            let day = document.getElementById("validationDate");
            day.max = "2008-01-01";
        }
    </script>

<script src="/static/jquery/jquery-3.5.1.min.js"></script>
<script src="/static/bootstrap413/js/popper.min.js"></script>
<script src="/static/datatables/js/jquery.dataTables.min.js"></script>
<script src="/static/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="/static/bootstrap413/js/bootstrap.min.js"></script>
<script src="/static/bootstrap413/js/bootstrap.bundle.js"></script>
</body>
</html>

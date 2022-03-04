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
<body>

    <br>
    <br>

    <div class="d-flex justify-content-center">
        <h2>Product List</h2>
    </div>
    <div class="container">
        <div class="row ">
            <div class="col-12" align="center">
                <a href="/?action=create" class="btn p-2" style="background: green;color: white">Add new product</a>
                <br>
                <br>
                <form action="">
                    <input type="search">
                    <input type="submit" value="Search">
                </form>
                <table id="example" class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th class="p-0 pb-3 pt-3">STT</th>
                        <th  class="p-0 pb-3 pt-3">Product Name</th>
                        <th  class="p-0 pb-3 pt-3">Price</th>
                        <th  class="p-0 pb-3 pt-3">Quantity</th>
                        <th  class="p-0 pb-3 pt-3">Color</th>
                        <th  class="p-0 pb-3 pt-3">Category</th>
                        <th  class="p-0 pb-3 pt-3">Action</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="product" items="${list}" >
                        <tr>
                            <td  class=""></td>
                            <td class="">${product.name}</td>
                            <td class="">${product.price}</td>
                            <td class="">${product.quantity}</td>
                            <td class="">${product.color}</td>
                            <td class="">${product.category_name}</td>
                            <td class="">
                                <button onclick="deleteCustomer('${product.id_product}','')" type="button" class="btn border-0 p-0" data-toggle="modal" data-target="#exampleModal" style="color: red;font-size:50px">
                                    <i style="font-size:30px" class="material-icons">delete</i>
                                </button>
                                <a  href="/?action=edit&id=${product.id_product}" style='color:#007bff;font-size:20px'>Edit</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>

                </table>


            </div>
        </div>
    </div>




    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Bạn có muốn xoá khách hàng tên <span id = "name-customer" ></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Huỷ</button>
                    <button type="button" class="btn btn-danger" onclick="submitFormDelete()">Xoá</button>
                </div>
            </div>
        </div>
    </div>

    <form hidden id="form-delete" method="post" action="/">
        <input type="text" name="action" value="delete">
        <input type="text" name="id" id="id-customer">
    </form>
    <script>
        function deleteCustomer(code, name) {
            document.getElementById("id-customer").value = code;
            document.getElementById("name-customer").innerText = name;
        }

        function submitFormDelete() {
            document.getElementById("form-delete").submit();
        }
        function checkDate(){
            let day = document.getElementById("validationDate");
            alert(123);
            day.min = new Date().toISOString().substr(0,10);
        }



    </script>

<script src="/static/jquery/jquery-3.5.1.min.js"></script>
<script src="/static/bootstrap413/js/popper.min.js"></script>
<script src="/static/datatables/js/jquery.dataTables.min.js"></script>
<script src="/static/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="/static/bootstrap413/js/bootstrap.min.js"></script>
<script src="/static/bootstrap413/js/bootstrap.bundle.js"></script>
    <script>
        $(document).ready( function () {
            $('#example').DataTable();
        } );
    </script>
</body>
</html>

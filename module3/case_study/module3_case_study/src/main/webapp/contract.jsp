<%--
  Created by IntelliJ IDEA.
  User: nguyenhoang
  Date: 2/19/22
  Time: 10:34 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>home</title>
    <link rel="stylesheet" href="/static/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/datatables/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
    <link rel="stylesheet" href="/static/css/nav.css">
    <%--  <link rel="stylesheet" href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">--%>
    <style>
        table{
            font-size: 0.75rem;
        }
    </style>
</head>
<body>

<div class="container-fluid border-bottom border-dark">
    <div class=" row p-2 container-fluid d-flex justify-content-between ">
        <div class="d-flex align-items-center">
            <a href=""><img src="static/image/logo.png" alt="" width="70px"></a>
        </div>
        <div class="d-flex align-items-center">
            <a href="">${userName==null?"Đăng nhập":userName}<i class="fa fa-sign-in"></i></a>
        </div>
    </div>
</div>

<div class="container-fluid border-bottom border-dark">
    <div class="row d-flex justify-content-between p-2 bg-light">
        <div class="d-flex align-items-center ">
            <nav class="navbar navbar-expand-sm">

                <!-- Links -->
                <ul class="navbar-nav ">
                    <li class="nav-item">
                        <a class="hover nav-link pr-2 pl-2 border-right border-dark" href="/">Trang chủ</a>
                    </li>
                    <li class="nav-item">
                        <a class="hover nav-link pr-2 pl-2 border-right border-dark" href="/ServletEmployee">Nhân viên</a>
                    </li>
                    <li class="nav-item">
                        <a class="hover nav-link pr-2 pl-2 border-right border-dark" href="/ServletCustomer">Khách hàng</a>
                    </li>
                    <li class="nav-item">
                        <a class=" hover nav-link pr-2 pl-2 border-right border-dark" href="/ServletService">Dịch vụ</a>
                    </li>
                    <li class="nav-item">
                        <a style="background: #3b5998;color: white" class="hover nav-link pr-2 pl-2 " href="/ServletContract">Hợp đồng</a>
                    </li>
                </ul>

            </nav>
        </div>
        <div class="d-flex align-items-center">
            <form action="" class="p-0 border">
                <input type="search" name="search" style="border-radius: 10px" placeholder="input to search">
                <input type="submit">
            </form>
        </div>
    </div>
</div>

<div class="container-fluid border-bottom border-dark">
    <div class="row">
        <div class="col-3 border-right border-dark">
            <c:choose>
                <c:when test="${doing==1}">
                    <form id ="create-form" action="/ServletContract?action=creae " method="post"  class="was-validated">
                        <div class="form-group">
                            <label>Id:</label>
                            <input type="text" class="form-control" name="id" value="${id}" readonly>
                        </div>
                        <div class="form-group">
                            <label >ngày bắt đầu :</label>
                            <input type="date" class="form-control" value="}"  name="birthday" required>
                            <div class="valid-feedback">hợp lệ</div>
                            <div class="invalid-feedback">Vui lòng nhập vào trường này</div>
                        </div>
                        <div class="form-group">
                            <label>ngày kết thúc :</label>
                            <input type="date" class="form-control" value="}"  name="birthday" required>
                            <div class="valid-feedback">hợp lệ</div>
                            <div class="invalid-feedback">Vui lòng nhập vào trường này</div>
                        </div>
                        <div class="form-group">
                            <label for="phone">Tiền đặt cọc</label><br>
                            <input type="text" onkeyup="checkPhone()" class="" id="phone"  name="phone" required>
                        </div>
                        <div class="form-group">
                            <label >nhân viên:</label><br>
                            <select name="employee" id="">
                                <c:forEach var="employee" items="${listEmployee}">
                                    <option value="${employee.getId()}">${employee.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="sel1">Khách hàng:</label><br>
                            <select class="form-control" id="sel1" name="${customer}">
                                <c:forEach var="customer" items="${listCustomer}">
                                    <option value="${customer.getId()}" >${customer.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="sel1">Dịch vụ:</label><br>
                            <select class="form-control" id="s" name="service">
                                <c:forEach var="service" items="${listService}">
                                    <option value="${service.id_service}" >${service.serviceName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <br>
                        <label>dịch vụ đi kèm:</label>
                        <input type="checkbox" id="contractDetail" onclick="addDetail()">
                        <br>
                        <div id ="contractContent" style="display: none">
                            <c:forEach var="attach" items="${listAttach}">
                                <input type="checkbox" id="${attach.getAttach_service_id()}" name="${attach.getAttach_service_id()}" value="${attach.attachServiceName}">
                                <label > ${attach.attachServiceName}</label><br>
                                <input min="0" max="10" type="number" pattern="[0-9]" id="quantityOf+${attach.getAttach_service_id()}" placeholder="số lượng" name="quantityOf+${attach.getAttach_service_id()}">
                                <br>
                            </c:forEach>
                        </div>
                        <br>
                            <button type="submit" id = "add" class="btn btn-primary">Thêm</button>
                        <a href="/ServletContract" type="submit" class="btn btn-danger">Huỷ</a>
                    </form>
                </c:when>
                <c:when test="${doing==2}">

                </c:when>
                <c:otherwise>

                    <br>
                    <br>
                    <form class="form-group" action="/ServletCustomer?action=search" method="post">
                        <input type="text" name="name" class="form-control mb-2 mr-sm-2" placeholder="tên hợp đồng" id="email">
                        <button type="submit" class="btn btn-primary mb-2">Tìm kiếm</button>
                    </form>
                    <br>
                    <a href="/ServletContract?action=create" class="d-inline-block p-2 bg-primary text-light">Thêm hợp đồng</a>

                </c:otherwise>
            </c:choose>
        </div>
        <div class="col-9">

            <div class="container">
                <br>
                <div class="row" align="center" style="text-align: center">
                    <h2 style="text-align: center">Danh sách hợp đồng </h2>
                </div>
                <br>
            </div>

            <table id="example" class="table table-striped table-bordered">
                <thead>
                <tr>
                    <th class="p-0 pb-3 pt-3">Mã hợp đồng</th>
                    <th  class="p-0 pb-3 pt-3">ngày bắt đầu</th>
                    <th  class="p-0 pb-3 pt-3">ngày kết thuc</th>
                    <th  class="p-0 pb-3 pt-3">tiền đặt cọc</th>
                    <th  class="p-0 pb-3 pt-3">tổng tiền</th>
                    <th  class="p-0 pb-3 pt-3">tên nhân viên</th>
                    <th  class="p-0 pb-3 pt-3">tên khách hàng</th>
                    <th  class="p-0 pb-3 pt-3">tên dịch vụ</th>
                    <th  class="p-0 pb-3 pt-3">các dịch vụ đi kèm</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="contract" items="${listContract}" >
                    <tr>
                        <td  class="p-0 pb-3 pt-3">${contract.contractId}</td>
                        <td class="p-0 pb-3 pt-3">${contract.contractStartDate}</td>
                        <td class="p-0 pb-3 pt-3">${contract.contractEndDate}</td>
                        <td class="p-0 pb-3 pt-3">${contract.contractDeposit}</td>
                        <td class="p-0 pb-3 pt-3">${contract.contractTotalMoney}</td>
                        <td class="p-0 pb-3 pt-3">${contract.employeeName}</td>
                        <td class="p-0 pb-3 pt-3">${contract.customerName}</td>
                        <td class="p-0 pb-3 pt-3">${contract.serviceName}</td>
                        <td class="p-0 pb-3 pt-3"></td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="row d-flex justify-content-center">
        <div align="center">
            <p>Địa chỉ: xxx</p>
            <p>Số điện thoại khẩn cấp:090-XXX-XXX</p>
            <p>Số điện thoại các phòng ban:0236-XXX-XXX</p>
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

<form hidden id="form-delete" method="post" action="/ServletCustomer">
    <input type="text" name="action" value="delete">
    <input type="text" name="id" id="id-customer">
</form>

<%--<form hidden id="form-edit" method="post" action="/ServletCustomer">--%>
<%--  <input type="text" name="action" value="checkValue">--%>
<%--  <input type="text" name="idPhone" id="idPhone" value="phone">--%>
<%--  <input type="text" name = "idCare" id ="card" value="card">--%>
<%--</form>--%>

<script>
    function deleteCustomer(code, name) {
        document.getElementById("id-customer").value = code;
        document.getElementById("name-customer").innerText = name;
    }

    // function checkValue() {
    //
    // }

    function submitCheckValue(){
        // let numPhone = document.getElementById("phone").value;
        // let idCard = document.getElementById("idCard").value;
        // document.getElementById("idPhone").value = numPhone;
        // document.getElementById("card").value = idCard;
        //document.getElementById("create-form").submit();
    }
    function checkPhone(){
        let editButton = document.getElementById("edit");
        let addButton = document.getElementById("add");
        let correct = document.getElementById("correct");
        let incorrect = document.getElementById("incorrect");
        let numPhone = document.getElementById("phone").value;
        let check = /(\(84\)\+90[0-9]{7})|(\(84\)\+91[0-9]{7})|(090[0-9]{7})|(091[0-9]{7})/;
        let result = check.test(numPhone);
        if(((""+numPhone).length==10&&result)||(result&&(""+numPhone).length==14)){
            correct.style.display = "block";
            incorrect.style.display = "none";
            editButton.disabled = true;
            addButton.disabled = true;
        }else{
            correct.style.display = "none";
            incorrect.style.display = "block";
            editButton.disabled = false;
            addButton.disabled = false;
        }
        // if(result){
        //   correct.style.display = "block";
        //   incorrect.style.display = "none";
        // }else{
        //   correct.style.display = "none";
        //   incorrect.style.display = "block";
        // }
    }

    function addDetail(){
        let addNumber = document.getElementById("contractDetail");
        let content = document.getElementById("contractContent");
        if(addNumber.checked){
            content.style.display="block";
        }else content.style.display="block";
    }

    function checkIdCard(){
        let editButton = document.getElementById("edit");
        let addButton = document.getElementById("add");
        let correct = document.getElementById("correctCard");
        let incorrect = document.getElementById("incorrectCard");
        let numPhone = document.getElementById("idCard").value;
        let check = /([0-9]{9})|([0-9]{12})/;
        let result = check.test(numPhone);
        if(((""+numPhone).length==9&&result)||(result&&(""+numPhone).length==12)){
            correct.style.display = "block";
            incorrect.style.display = "none";
            editButton.disabled = true;
            addButton.disabled = true;
        }else{
            editButton.disabled = false;
            addButton.disabled = false;
            correct.style.display = "none";
            incorrect.style.display = "block";
        }

        // if(result){
        //
        //     correct.style.display = "block";
        //     incorrect.style.display = "none";
        //
        // }else{
        //   correct.style.display = "none";
        //   incorrect.style.display = "block";
        // }
    }

    function submitFormDelete() {
        document.getElementById("form-delete").submit();
    }

    // $(document).ready(function() {
    //   $("#example").DataTable();
    // } );
</script>

<%--<script src="https://code.jquery.com/jquery-3.5.1.js"></script>--%>
<%--<script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap4.min.js"></script>--%>
<%--<script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>--%>
<script src="/static/jquery/jquery-3.5.1.min.js"></script>
<script src="/static/datatables/js/jquery.dataTables.min.js"></script>
<script src="/static/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="/static/bootstrap413/js/bootstrap.min.js"></script>
<script src="/static/bootstrap413/js/bootstrap.bundle.js"></script>
<script src="/static/bootstrap413/js/popper.min.js"></script>
<script>
    $(document).ready( function () {
        $('#example').DataTable();
    } );
</script>
</body>
</html>

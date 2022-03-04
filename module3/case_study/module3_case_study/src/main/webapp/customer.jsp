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
            <a style="background: #3b5998;color: white" class="hover nav-link pr-2 pl-2 border-right border-dark" href="/ServletCustomer">Khách hàng</a>
          </li>
          <li class="nav-item">
            <a class=" hover nav-link pr-2 pl-2 border-right border-dark" href="/ServletService">Dịch vụ</a>
          </li>
          <li class="nav-item">
            <a class="hover nav-link pr-2 pl-2 " href="/ServletContract">Hợp đồng</a>
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
            <form id ="create-form" action="/ServletCustomer?action=create " method="post"  class="was-validated">
              <div class="form-group">
                <label>Id:</label>
                <input type="text" class="form-control" name="id" value="${customer!=null?customer.getId():id}" readonly>
              </div>
              <div class="form-group">
                <label >Mã khách hàng:</label>
                <input type="text" class="form-control" value ="${customer!=null?customer.getCode():customerCode}" name="customerCode" readonly>
              </div>
              <div class="form-group">
                <label for="name">Tên:</label>
                <input type="text" pattern="[a-zA-Z]+" title="not number" class="form-control" value="${customer.getName()}" id="name" placeholder="Nhập tên" name="name" required>
                <div class="valid-feedback">hợp lệ</div>
                <div class="invalid-feedback">Vui lòng nhập vào trường này</div>
              </div>
              <div class="form-group">
                <label>ngày sinh:</label>
                <input type="date"  onchange="checkDate()" class="form-control" value="${customer.getBirthday()}" id="validationDate" placeholder="chọn ngày sinh" name="birthday" required>
                <div class="valid-feedback">hợp lệ</div>
                <div class="invalid-feedback">Vui lòng nhập vào trường này</div>
              </div>
              <div class="form-group">
                <label for="phone">Số điện thoại:</label>
                <input type="text"  onkeyup="checkPhone()" class="" id="phone" value="${customer.getPhone()}" placeholder="nhập số điện thoại" name="phone" required>
<%--                <div class="valid-feedback">hợp lệ</div>--%>
<%--                <div class="invalid-feedback">Vui lòng nhập vào trường này</div>--%>
                    <p style="color: #34ce57;display: none" id="correct">Hợp lệ</p>
                    <p style="color: red;"id="incorrect">Dữ liệu không hợp lệ</p>
              </div>
              <div class="form-group">
                <label for="idCard">Số CMND:</label>
                <input type="text" class="form-control" id="addres"  pattern="([0-9]{9})|([0-9]{12})"  class="" id="idCard" value="${customer.getId_card()}" placeholder="nhập số CMND" name="idCard" required>
                <div class="valid-feedback">hợp lệ</div>
                <div class="invalid-feedback">Dữ liệu không hợp lệ</div>
<%--                <p style="color: #34ce57;display: none" id="correctCard">Hợp lệ</p>--%>
<%--                <p style="color: red;"id="incorrectCard">Dữ liệu không hợp lệ</p>--%>
              </div>
              <div class="form-group">
                <label for="address">Địa chỉ:</label>
                <input type="text" pattern="[a-z][A-Z]" class="form-control" id="address" value="${customer.getAddress()}" placeholder="nhập địa chỉ" name="address" required>
                <div class="valid-feedback">hợp lệ</div>
                <div class="invalid-feedback">Vui lòng nhập vào trường này</div>
              </div>
              <div class="form-group">
                <label for="Cemail">Email:</label>
                <input type="email" class="form-control" id="Cemail" value="${customer.getEmail()}" placeholder="nhập email" name="email" required>
                <div class="valid-feedback">hợp lệ</div>
                <div class="invalid-feedback">Vui lòng nhập vào trường này</div>
              </div>
              <label for="sel1">chọn loại khách:</label>
              <select class="form-control" id="sel1" name="customerType">
                <c:forEach var="type" items="${listCustomerType}">
                    <option ${type.customer_type_id==customer.getCustomerTypeId()?'selected' : ''} value="${type.customer_type_id}">${type.customer_type_name}</option>
                </c:forEach>
              </select>

              <span>Giới tính:</span>
              <div class="form-check">
                <label class="form-check-label" for="radio1">
                  <input type="radio" ${customer.isGender()?'checked':''} class="form-check-input" id="radio1" name="gender" value="man" checked>Nam
                </label>
              </div>
              <div class="form-check">
                <label class="form-check-label" for="radio2">
                  <input type="radio" ${!customer.isGender()?'checked':''} class="form-check-input" id="radio2" name="gender" value="woman">Nữ
                </label>
              </div>
              <c:if test="${customer!=null}">
                <button type="submit" id = "edit" class="btn btn-primary">Sửa</button>
              </c:if>
              <c:if test="${customer==null}">
                <button type="submit" id = "add" class="btn btn-primary">Thêm</button>
              </c:if>
              <a href="/ServletCustomer" type="submit" class="btn btn-danger">Huỷ</a>
            </form>
          </c:when>
          <c:when test="${doing==2}">

          </c:when>
          <c:otherwise>

              <br>
              <br>
              <form class="form-group" action="/ServletCustomer?action=search" method="post">
                <input type="text" name="name" class="form-control mb-2 mr-sm-2" placeholder="tên khách hàng" id="email">
                <button type="submit" class="btn btn-primary mb-2">Tìm kiếm</button>
              </form>
              <br>
              <a href="/ServletCustomer?action=create" class="d-inline-block p-2 bg-primary text-light">Thêm khách hàng</a>

          </c:otherwise>
        </c:choose>
    </div>
    <div class="col-9">

      <div class="container">
        <br>
        <div class="row" align="center" style="text-align: center">
          <h2 style="text-align: center">Danh sách khách hàng </h2>
        </div>
        <br>
      </div>

      <table id="example" class="table table-striped table-bordered">
        <thead>
        <tr>
          <th class="p-0 pb-3 pt-3">STT</th>
          <th  class="p-0 pb-3 pt-3">Mã khách hàng</th>
          <th  class="p-0 pb-3 pt-3">Tên</th>
          <th  class="p-0 pb-3 pt-3">Ngày sinh</th>
          <th  class="p-0 pb-3 pt-3">Giới tính</th>
          <th  class="p-0 pb-3 pt-3">số CMND</th>
          <th  class="p-0 pb-3 pt-3">Số điện thoai</th>
          <th  class="p-0 pb-3 pt-3">Email</th>
          <th  class="p-0 pb-3 pt-3">Địa chỉ</th>
          <th  class="p-0 pb-3 pt-3">Loại khách</th>
          <th  class="p-0 pb-3 pt-3">Thay đổi</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="customer" items="${list}" >
          <tr>
            <td  class="p-0 pb-3 pt-3">${customer.index}</td>
            <td class="p-0 pb-3 pt-3">${customer.getCode()}</td>
            <td class="p-0 pb-3 pt-3">${customer.getName()}</td>
            <td class="p-0 pb-3 pt-3">${customer.birthday}</td>
            <td class="p-0 pb-3 pt-3">${customer.gender?"Nam":"Nữ"}</td>
            <td class="p-0 pb-3 pt-3">${customer.id_card}</td>
            <td class="p-0 pb-3 pt-3">${customer.phone}</td>
            <td class="p-0 pb-3 pt-3">${customer.email}</td>
            <td class="p-0 pb-3 pt-3">${customer.address}</td>
            <td class="p-0 pb-3 pt-3">${customer.customerType}</td>
            <td class="p-0 pb-3 pt-3">
              <button onclick="deleteCustomer('${customer.getId()}','${customer.getName()}')" type="button" class="btn btn-primary p-0 border-0" data-toggle="modal" data-target="#exampleModal" style="color: red;font-size:10px">
                <i class="material-icons">delete</i>
              </button>
               <a  href="/ServletCustomer?action=edit&id=${customer.getId()}" style='color:#007bff;font-size:14px'><i class='far fa-edit'></i></a>
            </td>
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

  function checkDate(){
    let day = document.getElementById("validationDate");
    alert(123);
    day.min = new Date().toISOString().substr(0,10);
  }

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

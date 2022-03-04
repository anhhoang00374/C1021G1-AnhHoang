<%--
  Created by IntelliJ IDEA.
  User: nguyenhoang
  Date: 2/18/22
  Time: 7:37 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Service</title>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="/static/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/css/nav.css">
    <link rel="stylesheet" href="/static/css/home.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container-fluid border-bottom border-dark">
    <div class=" row p-2 container-fluid d-flex justify-content-between ">
        <div class="d-flex align-items-center">
            <a href=""><img src="static/image/logo.png" alt="" width="70px"></a>
        </div>
        <div class="d-flex align-items-center">
            <a href="">${userName==null?"Đăng nhập":userName} <i class="fa fa-sign-in"></i></a>
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
                        <a style="background: #3b5998;color: white" class=" hover nav-link pr-2 pl-2 border-right border-dark" href="/ServletService">Dịch vụ</a>
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
        <div class="col-3 border-right border-dark" id = "container-logIn">
            <br>
            <br>
            <a href="/ServletService?action=addRoom" class="btn" style="background: green; color: white">Thêm Room</a>
            <br>
            <br>
            <a href="#" class="btn" style="background: green; color: white">Thêm House</a>
            <br>
            <br>
            <a href="#" class="btn" style="background: green; color: white">Thêm Villa</a>
            <br>
            <br>
            <c:if test="${doing==0}">
                <form action="/ServletService?action=addRoom" method="post">
                    <div class="form-group">
                        <label>Id:</label>
                        <input type="text" class="form-control" name="id" value="${id}" readonly>
                    </div>
                    <div class="form-group">
                        <label >Mã dịch vụ:</label>
                        <input type="text" class="form-control" value ="${code}" name="code" readonly>
                    </div>
                    <div class="form-group">
                        <label >Tên dịch vụ:</label>
                        <input type="text" class="form-control" value="" placeholder="Nhập tên" name="service-name" required>
                        <div class="valid-feedback">hợp lệ</div>
                        <div class="invalid-feedback">Vui lòng nhập vào trường này</div>
                    </div>
                    <div class="form-group">
                        <label>Diện tích:</label>
                        <input type="text" class="form-control" value="" id="" placeholder="Diện tích" name="area" required>
                        <div class="valid-feedback">hợp lệ</div>
                        <div class="invalid-feedback">Vui lòng nhập vào trường này</div>
                    </div>
                    <div class="form-group">
                        <label>Số lượng người tối đa:</label>
                        <input type="text" class="form-control" name="people" value="" >
                    </div>
                    <div class="form-group">
                        <label >Kiểu thuê</label>
                        <select class="form-control" id="sel" name="rentType">
                            <c:forEach var="type" items="${listRent}">
                                <option  value="${type. id}">${type.rentName}</option>
                            </c:forEach>
                        </select>
                    </div>



                    <div class="form-group">
                        <label for="">Tên loại dịch vụ:</label>
                        <select class="form-control" id="sel1" name="serviceType">
                            <c:forEach var="type" items="${listType}">
                                <c:if test="${type.serviceTypeId==3}">
                                    <option  value="${type.serviceTypeId}">${type.serviceTypeName}</option>
                                </c:if>

                            </c:forEach>
                        </select>
                    </div>
<%--                    <div class="form-group">--%>
<%--                        <label >Dịch vụ miễn phí đi kèm:</label>--%>
<%--                        <input type="text" class="form-control" value="" name="free-service" required>--%>
<%--                        <div class="valid-feedback">hợp lệ</div>--%>
<%--                        <div class="invalid-feedback">Vui lòng nhập vào trường này</div>--%>
<%--                    </div>--%>
                    <input type="submit" style="background: green; color: white" value="Thêm">
                </form>
            </c:if>
        </div>
        <div class="col-9">

            <h2 style="text-align: center">Danh sách dịch vụ hiện tại</h2>
            <br>
            <h2 style="text-align: center">Danh sách Villa</h2>
            <br>
            <table id="villa">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Tên dịch vụ</th>
                    <th>Mã dịch vụ</th>
                    <th>Diện tích</th>
                    <th>Giá</th>
                    <th>Số người</th>
                    <th>Kiểu thuê</th>
                    <th>Giá kiểu thuê</th>
                    <th>Chuẩn phòng</th>
                    <th>Tiện nghi khác</th>
                    <th>Diện tích hồ bơi</th>
                    <th>Số tầng</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach var="villa" items="${villaList}">
                        <tr>
                            <td>${villa.index}</td>
                            <td>${villa.getServiceName()}</td>
                            <td>${villa.getCode()}</td>
                            <td>${villa.getServiceArea()}</td>
                            <td>${villa.getServiceCost()}</td>
                            <td>${villa.getServiceMaxPeople()}</td>
                            <td>${villa.getRent_type()}</td>
                            <td>${villa.rent_cost}</td>
                            <td>${villa.standard_room}</td>
                            <td>${villa.description_other_convenience}</td>
                            <td>${villa.pool_area}</td>
                            <td>${villa.number_of_floors}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br>
            <h2 style="text-align: center">Danh sách House</h2>
            <br>
            <table id="house">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Tên dịch vụ</th>
                    <th>Mã dịch vụ</th>
                    <th>Diện tích</th>
                    <th>Giá</th>
                    <th>Số người</th>
                    <th>Kiểu thuê</th>
                    <th>Giá kiểu thuê</th>
                    <th>Chuẩn phòng</th>
                    <th>Tiện nghi khác</th>
                    <th>Số tầng</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="house" items="${houseList}">
                    <tr>
                        <td>${house.index}</td>
                        <td>${house.getServiceName()}</td>
                        <td>${house.getCode()}</td>
                        <td>${house.getServiceArea()}</td>
                        <td>${house.getServiceCost()}</td>
                        <td>${house.getServiceMaxPeople()}</td>
                        <td>${house.getRent_type()}</td>
                        <td>${house.rent_cost}</td>
                        <td>${house.standard_room}</td>
                        <td>${house.description_other_convenience}</td>
                        <td>${house.number_of_floors}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <br>
            <h2 style="text-align: center">Danh sách Room</h2>
            <br>
            <table id="room">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Tên dịch vụ</th>
                    <th>Mã dịch vụ</th>
                    <th>Diện tích</th>
                    <th>Giá</th>
                    <th>Số người</th>
                    <th>Kiểu thuê</th>
                    <th>Giá kiểu thuê</th>
                    <th>Dịch vụ miễn phí</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="room" items="${roomList}">
                    <tr>
                        <td>${room.index}</td>
                        <td>${room.getServiceName()}</td>
                        <td>${room.getCode()}</td>
                        <td>${room.getServiceArea()}</td>
                        <td>${room.getServiceCost()}</td>
                        <td>${room.getServiceMaxPeople()}</td>
                        <td>${room.getRent_type()}</td>
                        <td>${room.rent_cost}</td>
                        <td>${room.name_complimentary}</td>
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

<script src="/static/jquery/jquery-3.5.1.min.js"></script>
<script src="/static/datatables/js/jquery.dataTables.min.js"></script>
<script src="/static/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="/static/bootstrap413/js/bootstrap.min.js"></script>
<script src="/static/bootstrap413/js/bootstrap.bundle.js"></script>
<script src="/static/bootstrap413/js/popper.min.js"></script>
<script>
    $(document).ready( function () {
        $('#house').DataTable();
        $('#room').DataTable();
        $('#villa').DataTable();
    } );
</script>
</body>
</html>

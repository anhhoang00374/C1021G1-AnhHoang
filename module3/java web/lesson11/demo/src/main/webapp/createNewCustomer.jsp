<%--
  Created by IntelliJ IDEA.
  User: nguyenhoang
  Date: 2/8/22
  Time: 4:58 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2 style="text-align: center">Create new Customer</h2>
    <div align = "center">
        <form action="save" method="get">
           <table>
             <tr>
                 <td>id</td>
                 <td>
                     <c:if test="${messeger!=null}">
                         <p style="color: red">${messeger}</p>
                     </c:if>
                     <input type="text" name="id">
                 </td>
             </tr>
               <tr>
                   <td>name</td>
                   <td>
                       <input type="text" name="name" value="${name}">
                   </td>
               </tr>
               <tr>
                   <td>phone</td>
                   <td>
                       <input type="text" name="phone" value="${phone}">
                   </td>
               </tr>
               <tr>
                   <td>email</td>
                   <td>
                       <input type="text" name="email" value="${email}">
                   </td>
               </tr>
               <tr><input type="submit" value="save"></tr>
           </table>
        </form>
    </div>
</body>
</html>

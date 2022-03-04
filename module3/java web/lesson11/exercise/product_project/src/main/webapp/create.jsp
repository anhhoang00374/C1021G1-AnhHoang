<%--
  Created by IntelliJ IDEA.
  User: nguyenhoang
  Date: 2/14/22
  Time: 3:30 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <div align="center">
      <h2>Create customer</h2>
      <form action="/?action=create" method="post">
          <table>
              <tr>
                  <th>Name</th>
                  <td><input type="text" name="name" placeholder="input name"></td>
              </tr>
              <tr>
                  <th>Price</th>
                  <td><input type="text" name="price" placeholder="input price"></td>
              </tr>
              <tr>
                  <th>Producer</th>
                  <td><input type="text" name="producer" placeholder="input producer"></td>
              </tr>
          </table>
          <input type="submit" value ="ADD" style="background: green; padding: 5px; color: white">
      </form>
  </div>
</body>
</html>

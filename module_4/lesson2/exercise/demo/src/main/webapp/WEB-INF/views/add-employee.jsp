<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
  <title>Spring MVC Form Handling</title>
</head>
<body>
<h2>Employee</h2>
<%--@elvariable id="employee1" type=""--%>
<form:form method="POST" action="addEmployee" modelAttribute="employee1">
  <br/>
  Name: <form:input path="name" />
  <input type="submit" value="Submit" />
</form:form>
<form action="/id" method="get">
  <input type="text" name="id" value="1">
  <input type="submit">
</form>
</body>
</html>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: nikita
  Date: 01.10.21
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aimprosoft Java</title>
    <link href="css/main.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="header_refs">
    <a href="/aimlearning_war_exploded/">Home page</a>
    <a href="/aimlearning_war_exploded/EmployeeServlet">All Employees</a>
    <a href="/aimlearning_war_exploded/addEmployee.jsp">Add Employee</a>
    <a href="/aimlearning_war_exploded/addDepartment.jsp">Add Department</a>
</div>

<div align="center" style="margin-top: 50px;">



    <%
        if(request.getParameter("wrong") != null){
            PrintWriter printWriter = response.getWriter();
            printWriter.println(request.getParameter("wrong"));
        }
    %>

    <form action="addDepartmentServlet" method="post">
        Please enter your name of department:  <input type="text" name="name" class="input_param" size="15px"> <br>
        Please enter your address of department:  <input type="text" name="address" class="input_param" size="15px"> <br>
        <input type="submit" value="submit">
    </form>
</div>


</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: nikita
  Date: 30.09.21
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Aimprosoft Java</title>
    <link href="css/main.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="header_refs">
    <a href="/aimlearning_war_exploded/HomePageServlet">Home page</a>
    <a href="/aimlearning_war_exploded/EmployeeServlet">All Employees</a>
    <a href="/aimlearning_war_exploded/addEmployeeServlet">Add Employee</a>
    <a href="/aimlearning_war_exploded/addDepartmentServlet">Add Department</a>
</div>


<div align="center" style="margin-top: 50px;">

    <c:if test="${empty employees}">
        <p>Empty</p>
    </c:if>

    <c:if test="${!empty requestScope.employees}">
        <table border="1">
            <tr>
                <th>Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Salary</th>
                <th>Hire Date</th>
                <th>Department id</th>
            </tr>
            <c:forEach var="employee" items="${requestScope.employees}">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.firstName}</td>
                    <td>${employee.lastName}</td>
                    <td>${employee.email}</td>
                    <td>${employee.salary}</td>
                    <td>${employee.hireDate}</td>
                    <td>${employee.idDepartment}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>


</div>

</body>
</html>

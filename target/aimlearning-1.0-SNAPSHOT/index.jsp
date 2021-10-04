<%@ page import="java.util.List" %>
<%@ page import="com.aimprosoft.aimlearning.model.Department" %>
<%@ page import="com.aimprosoft.aimlearning.DAO.DepartmentDAOImpl" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Aimprosoft Java</title>
    <link href="css/main.css" rel="stylesheet" type="text/css">
</head>
<body>


<div class="departments_main">
    <form>
        <div class="header_refs">
            <a href="/aimlearning_war_exploded/">Home page</a>
            <a href="/aimlearning_war_exploded/allEmployees.jsp">All Employees</a>
            <a href="/aimlearning_war_exploded/addEmployee.jsp">Add Employee</a>
            <a href="/aimlearning_war_exploded/addDepartment.jsp">Add Department</a>
        </div>
    </form>

    <div class="departments_all">
        <%
            List<Department> departments = new DepartmentDAOImpl().getAllDepartments();
            PrintWriter printWriter = response.getWriter();
            for(int i = 0 ; i < departments.size(); i++){
                printWriter.println("<a class=\"department_href\"  href=\"http://localhost:8080/aimlearning_war_exploded/departmentByid.jsp?id="+ departments.get(i).getIdDepartment() +"\">"
                        + "Id: " + departments.get(i).getIdDepartment() +
                        " name: " + departments.get(i).getName() +
                        " address: " + departments.get(i).getAddress() +
                        "</a>      " +
                        "<a class=\"update_button\" href=\"/aimlearning_war_exploded/updateDepartmentServlet?id=" + departments.get(i).getIdDepartment() +
                        "&name=" + departments.get(i).getName() +
                        "&address=" + departments.get(i).getAddress() + "\">    Update this department</a> </p> <br>" );
            }
        %>
    </div>
</div>

</body>
</html>
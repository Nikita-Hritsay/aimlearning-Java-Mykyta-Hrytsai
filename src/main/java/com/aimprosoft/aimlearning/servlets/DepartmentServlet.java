package com.aimprosoft.aimlearning.servlets;

import com.aimprosoft.aimlearning.DAO.DepartmentDAOImpl;
import com.aimprosoft.aimlearning.DAO.EmployeeDAOImpl;
import com.aimprosoft.aimlearning.model.Department;
import com.aimprosoft.aimlearning.model.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DepartmentServlet", value = "/DepartmentServlet")
public class DepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        switch (action){
            case "delete":
                new DepartmentDAOImpl().deleteDepartment(Integer.parseInt(request.getParameter("id")));
                response.sendRedirect("/aimlearning_war_exploded/");
                break;
            case "update":
                request.getRequestDispatcher("updateDepartment.jsp").forward(request, response);
                break;
        }
        List<Employee> employees = new DepartmentDAOImpl().getById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("/departmentByid.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        new DepartmentDAOImpl().updateDepartment(new Department(Integer.parseInt(request.getParameter("id")),
                request.getParameter("name"),
                request.getParameter("address")));
        response.sendRedirect("/aimlearning_war_exploded/");
    }
}

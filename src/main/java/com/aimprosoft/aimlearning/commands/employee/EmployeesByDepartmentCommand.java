package com.aimprosoft.aimlearning.commands.employee;

import com.aimprosoft.aimlearning.commands.ICommand;
import com.aimprosoft.aimlearning.exceptions.DBException;
import com.aimprosoft.aimlearning.models.Employee;
import com.aimprosoft.aimlearning.services.Impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EmployeesByDepartmentCommand implements ICommand {

    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DBException {
        List<Employee> employees = employeeService.getByIdDepartment(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("idDepartment", request.getParameter("id"));
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("/WEB-INF/pages/departmentByid.jsp").forward(request, response);
    }

}

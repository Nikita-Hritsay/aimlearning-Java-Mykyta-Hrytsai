package com.aimprosoft.aimlearning.commands.department;

import com.aimprosoft.aimlearning.DAO.Impl.DepartmentDAOImpl;
import com.aimprosoft.aimlearning.commands.ICommand;
import com.aimprosoft.aimlearning.models.Department;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DisplayAllDepartmentCommand implements ICommand {

    private final DepartmentDAOImpl departmentDAO = new DepartmentDAOImpl();

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Department> departments = departmentDAO.getAllDepartments();
        req.setAttribute("departments", departments);
        req.getRequestDispatcher("homePage.jsp").forward(req, resp);
    }

}
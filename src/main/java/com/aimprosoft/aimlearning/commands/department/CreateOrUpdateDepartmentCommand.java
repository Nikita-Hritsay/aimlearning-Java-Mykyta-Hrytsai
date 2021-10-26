package com.aimprosoft.aimlearning.commands.department;

import com.aimprosoft.aimlearning.commands.ICommand;
import com.aimprosoft.aimlearning.exceptions.DBException;
import com.aimprosoft.aimlearning.exceptions.ValidationException;
import com.aimprosoft.aimlearning.models.Department;
import com.aimprosoft.aimlearning.services.Impl.DepartmentServiceImpl;
import com.aimprosoft.aimlearning.utils.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CreateOrUpdateDepartmentCommand implements ICommand {

    private final DepartmentServiceImpl departmentService = new DepartmentServiceImpl();

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DBException {
        request.setCharacterEncoding("UTF-8");
        Department department = getDepartment(request);
        try {
            departmentService.createOrUpdate(department);
            response.sendRedirect("/displayAllDepartments");
        } catch (ValidationException exception) {
            request.setAttribute("errors", exception.getErrors());
            request.setAttribute("department", department);
            request.getRequestDispatcher("/WEB-INF/pages/createOrUpdateDepartment.jsp").forward(request, response);
        }
    }

    private Department getDepartment(HttpServletRequest request) {
        return new Department()
                .withIdDepartment(NumberUtils.getInt(request.getParameter("id")))
                .withName(request.getParameter("name"))
                .withAddress(request.getParameter("address"));
    }
}

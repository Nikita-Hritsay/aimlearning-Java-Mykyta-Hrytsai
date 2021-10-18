package com.aimprosoft.aimlearning.commands.department;

import com.aimprosoft.aimlearning.DAO.Impl.DepartmentDAOImpl;
import com.aimprosoft.aimlearning.commands.ICommand;
import com.aimprosoft.aimlearning.exceptions.ValidationException;
import com.aimprosoft.aimlearning.models.Department;
import com.aimprosoft.aimlearning.utils.GetError;
import com.aimprosoft.aimlearning.utils.GetInt;
import net.sf.oval.Validator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CreateOrUpdateDepartmentCommand implements ICommand {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Department department = getDepartment(req);
        try {
            new DepartmentDAOImpl().createOrUpdate(department);
            req.getRequestDispatcher("displayAllDepartments").forward(req, resp);
        } catch (ValidationException exception) {
            req.setAttribute("errors", GetError.getErrors(new Validator().validate(department)));
            req.setAttribute("department", department);
            req.getRequestDispatcher("createOrUpdateDepartment.jsp").forward(req, resp);
        }
    }

    private Department getDepartment(HttpServletRequest request) {
        Department department = new Department()
                .withIdDepartment(GetInt.getInt(request.getParameter("id")))
                .withName(request.getParameter("name"))
                .withAddress(request.getParameter("address"));
        return department;
    }
}

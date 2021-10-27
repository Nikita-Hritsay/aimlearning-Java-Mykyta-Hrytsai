package com.aimprosoft.aimlearning.validations.employee;

import com.aimprosoft.aimlearning.dao.Impl.HibernateEmployeeDAOImpl;
import com.aimprosoft.aimlearning.models.Employee;
import net.sf.oval.Validator;
import net.sf.oval.constraint.CheckWithCheck;
import net.sf.oval.context.OValContext;


public class IsUniqueEmail implements CheckWithCheck.SimpleCheck {
    private final HibernateEmployeeDAOImpl employeeDAO = new HibernateEmployeeDAOImpl();

    @Override
    public boolean isSatisfied(Object validatedObject, Object value, OValContext context, Validator validator) {
        try {
            return !employeeDAO.existsByEmail((Employee) validatedObject);
        } catch (Exception e) {
            return false;
        }
    }
}

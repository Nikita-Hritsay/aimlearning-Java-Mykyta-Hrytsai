package com.aimprosoft.aimlearning.dao.Impl;

import com.aimprosoft.aimlearning.config.HibernateSessionFactory;
import com.aimprosoft.aimlearning.dao.EmployeeDAO;
import com.aimprosoft.aimlearning.exceptions.DBException;
import com.aimprosoft.aimlearning.exceptions.ValidationException;
import com.aimprosoft.aimlearning.models.Employee;

import com.aimprosoft.aimlearning.utils.NumberUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class HibernateEmployeeDAOImpl implements EmployeeDAO {

    @Override
    public List<Employee> getAllEmployees() throws DBException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.createQuery("FROM Employee", Employee.class).list();
        } catch (Exception e) {
            throw new DBException(e.getMessage());
        }
    }

    @Override
    public Employee getById(int id) throws DBException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(Employee.class, id);
        } catch (Exception e) {
            throw new DBException(e.getMessage());
        }
    }

    @Override
    public void saveOrUpdate(Employee employee) throws DBException {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(employee);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
            throw new DBException(e.getMessage());
        }
    }

    @Override
    public void deleteEmployee(int id) throws DBException {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(getById(id));
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
            throw new DBException(e.getMessage());
        }
    }

    @Override
    public boolean existsByEmail(Employee employee) throws DBException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Employee check = (Employee) session.createQuery("FROM Employee where email='" + employee.getEmail() + "'").uniqueResult();
            return check != null && !Objects.equals(check.getId(), employee.getId());
        } catch (Exception e) {
            throw new DBException(e.getMessage());
        }
    }

    @Override
    public void createOrUpdate(Employee employee) throws ValidationException, DBException {
        saveOrUpdate(employee);
    }

}

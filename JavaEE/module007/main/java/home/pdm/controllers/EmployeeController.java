package home.pdm.controllers;

import home.pdm.dao.IEmployeeDAO;
import home.pdm.model.Employee;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class EmployeeController {

    private IEmployeeDAO employeeDao;
    private HibernateTransactionManager txManager;

    public void setEmployeeDao(IEmployeeDAO employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional
    public void createEmployee(Employee employee) {
        employeeDao.createEmployee(employee);
    }

    @Transactional
    public void deleteEmployee(String surname, String name) {
        employeeDao.deleteEmployee(surname, name);
    }

    @Transactional
    public Employee searchForEmployee(String surname, String name) {
        return employeeDao.findForEmployee(surname, name);
    }

    @Transactional
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    public void setTxManager(HibernateTransactionManager txManager) {
        this.txManager = txManager;
    }

    public HibernateTransactionManager getTxManager() {
        return txManager;
    }
}

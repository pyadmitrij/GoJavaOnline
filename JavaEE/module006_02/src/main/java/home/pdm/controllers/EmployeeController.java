package home.pdm.controllers;

import home.pdm.dao.IEmployeeDAO;
import home.pdm.model.Employee;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;


public class EmployeeController {

    private PlatformTransactionManager txManager;
    private IEmployeeDAO employeeDao;

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setEmployeeDao(IEmployeeDAO employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional
    public void deleteEmployee(Integer id) {
        employeeDao.deleteEmployee(id);
    }

    @Transactional
    public Employee searchForEmployee(String surname, String name) {
        return employeeDao.searchForEmployee(surname, name);
    }

    @Transactional
    public List<Employee> findAll() {

        TransactionStatus status = txManager.getTransaction(
                new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED));

        try {
            List<Employee> result = employeeDao.findAll();
            txManager.commit(status);
            return result;
        } catch (Exception e) {
            txManager.rollback(status);
            throw new RuntimeException(e);
        }
    }

}

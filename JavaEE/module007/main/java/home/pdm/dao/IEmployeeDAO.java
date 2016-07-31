package home.pdm.dao;

import home.pdm.model.Employee;

import java.util.List;

public interface IEmployeeDAO {

    void createEmployee(Employee employee);

    void deleteEmployee(Integer id);

    void deleteEmployee(String surname, String name);

    Employee findForEmployee(String surname, String name);

    Employee findForEmployee(int id);

    List<Employee> findAll();

}

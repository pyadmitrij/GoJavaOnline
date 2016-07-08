package home.pdm.dao;

import home.pdm.model.Employee;

import java.util.List;

public interface IEmployeeDAO {

    Employee load(int id);

    void deleteEmployee(Integer id);

    Employee searchForEmployee(String surname, String name);

    List<Employee> findAll();

}

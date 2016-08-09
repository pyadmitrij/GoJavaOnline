package home.pdm.hibernate;

import home.pdm.dao.IEmployeeDAO;
import home.pdm.model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class HEmployeeDAO implements IEmployeeDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(HEmployeeDAO.class);

    private SessionFactory sessionFactory;

    @Override
    public void createEmployee(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        Employee employee = findForEmployee(id);
        sessionFactory.getCurrentSession().delete(id);
    }

    @Override
    public void deleteEmployee(String surname, String name) {
        Employee employee = findForEmployee(surname,name);
        sessionFactory.getCurrentSession().delete(employee);
    }

    @Override
    public Employee findForEmployee(String surname, String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Employee e where e.firstName like :firstName and e.name like :name");
        query.setParameter("name",name);
        query.setParameter("surname", surname);
        return (Employee) query.uniqueResult();
    }

    @Override
    public Employee findForEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Employee e where e.employeeId = :employeeId");
        query.setParameter("employeeId", id);
        return (Employee) query.uniqueResult();
    }

    @Override
    public List<Employee> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select o from Employee o").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}

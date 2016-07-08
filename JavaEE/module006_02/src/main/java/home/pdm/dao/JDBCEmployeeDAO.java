package home.pdm.dao;

import home.pdm.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCEmployeeDAO implements IEmployeeDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(JDBCEmployeeDAO.class);

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void createNewUser(String surname, String name, Date birthDate, String phone, Double salary, Integer positionId) {
        String query = "INSERT INTO EMPLOYEES (SURNAME, NAME, BIRTH_DATE, PHONE, SALARY, POSITION_ID) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            LOGGER.info("Connect with databased USERS and Add new USER");
            statement.setString(1, surname);
            statement.setString(2, name);
            statement.setDate(3, birthDate);
            statement.setString(4, phone);
            statement.setDouble(5, salary);
            statement.setInt(6, positionId);

            statement.executeUpdate();

        } catch (SQLException sqlEx) {
            LOGGER.error("An error has occurred query to the database 'USERS': " + sqlEx);
            throw new RuntimeException();
        }

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Employee load(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Employee WHERE ID = ?")) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return getEmployee(resultSet);
            } else {
                throw new RuntimeException("Cannot find Employee with ID " + id);
            }

        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void deleteEmployee(Integer id) {
        String query = "DELETE FROM EMPLOYEES WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            LOGGER.info("Connect with databased USERS and delete Users");
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException sqlEx) {
            LOGGER.error("An error has occurred query to the database 'USERS': " + sqlEx);
            throw new RuntimeException();
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Employee searchForEmployee(String surname, String name) {
        Employee result = null;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE SURNAME = ? AND NAME = ?");
            statement.setString(1, surname);
            statement.setString(2, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = getEmployee(resultSet);
            } else {
                throw new RuntimeException("There is no employee " + name + " " + surname + " in database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Employee> findAll() {
        List<Employee> result = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM EMPLOYEE");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(getEmployee(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Employee getEmployee(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployeeId(resultSet.getInt("ID"));
        employee.setFirstName(resultSet.getString("FIRST_NAME"));
        employee.setLastName(resultSet.getString("LAST_NAME"));
        employee.setBirthDate(resultSet.getDate("BIRTH_DATE"));
        employee.setPhone(resultSet.getString("PHONE"));
        employee.setSalary(resultSet.getDouble("SALARY"));
        employee.setPositionId(resultSet.getInt("POSITION_ID"));
        return employee;
    }

}

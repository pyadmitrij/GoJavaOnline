package home.pdm.dao;

import home.pdm.model.PreparedDish;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCPreparedDAO implements IPreparedDishDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addPreparedDish(PreparedDish preparedDish) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO PREPARED_DISHES VALUES (?,?,?,?,?)");
            statement.setInt(1, preparedDish.getId());
            statement.setInt(2, preparedDish.getDishId());
            statement.setInt(3, preparedDish.getEmployeeId());
            statement.setInt(4, preparedDish.getOrderId());
            statement.setDate(5, preparedDish.getDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<PreparedDish> findAllPreparedDishes() {
        List<PreparedDish> result = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM PREPARED_DISHES");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(getPreparedDishFromQuery(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private PreparedDish getPreparedDishFromQuery(ResultSet resultSet) throws SQLException {
        return new PreparedDish(
                resultSet.getInt("id"),
                resultSet.getInt("dish_id"),
                resultSet.getInt("employee_id"),
                resultSet.getInt("order_id"),
                resultSet.getDate("date"));
    }

}

package home.pdm.dao;

import home.pdm.model.Order;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JDBCOrderDAO implements IOrderDAO {

    private DataSource dataSource;

    @Override
    public void createOrder(Order order) {
        try {

            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO ORDERS VALUES (?,?,?,?)");
            statement.setInt(1, order.getOrderId());
            statement.setInt(2, order.getEmployeeId());
            statement.setInt(3, order.getTableNumber());
            statement.setBoolean(4, order.isOpen());
            statement.executeUpdate();
            for (Map.Entry<Integer, Integer> dishesInOrder : order.getOrderedDishes().entrySet()) {
                PreparedStatement dishStatement = connection.prepareStatement("INSERT INTO ORDERED_DISHES VALUES (?,?,?)");
                dishStatement.setInt(1, order.getOrderId());
                dishStatement.setInt(2, dishesInOrder.getKey());
                dishStatement.setInt(3, dishesInOrder.getValue());
                dishStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteOrder(int id) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ORDERS WHERE ID = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next() && resultSet.getBoolean("is_open")) {
                statement = connection.prepareStatement("DELETE FROM ORDERS WHERE ID = ?");
                statement.setInt(1, id);
                PreparedStatement dishesInOrderStatement = connection.prepareStatement("DELETE FROM ORDERED_DISHES WHERE ORDER_ID = ?");
                dishesInOrderStatement.setInt(1, id);
                dishesInOrderStatement.executeUpdate();
                statement.executeUpdate();
            } else {
                throw new RuntimeException("No such order with id= " + id + " in database or order is closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void addDishToOrder(int orderId, int dishId, int quantity) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ORDERS WHERE ID = ?");
            statement.setInt(1, orderId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next() && resultSet.getBoolean("is_open")) {
                statement = connection.prepareStatement("INSERT INTO ORDERED_DISHES VALUES (?,?,?)");
                statement.setInt(1, orderId);
                statement.setInt(2, dishId);
                statement.setInt(3, quantity);
                statement.executeUpdate();
            } else {
                throw new RuntimeException("No such order with id= " + orderId + " in database or order is closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeDishFromOrder(int orderId, int dishId) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ORDERS WHERE ID = ?");
            statement.setInt(1, orderId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next() && resultSet.getBoolean("is_open")) {
                statement = connection.prepareStatement("DELETE FROM ORDERED_DISHES WHERE ORDER_ID = ? AND DISH_ID = ?");
                statement.setInt(1, orderId);
                statement.setInt(2, dishId);
                statement.executeUpdate();
            } else {
                throw new RuntimeException("No such order with id= " + orderId + " in database or order is closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void closeOrder(int id) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ORDERS WHERE ID = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next() && resultSet.getBoolean("is_open")) {
                statement = connection.prepareStatement("UPDATE ORDERS SET IS_OPEN = ? WHERE ID = ?");
                statement.setBoolean(1, false);
                statement.setInt(2, id);
                statement.executeUpdate();
            } else {
                throw new RuntimeException("No such order with id= " + id + " in database or order is closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Order> findAllOpenOrders() {
        List<Order> result = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ORDERS WHERE IS_OPEN = ?");
            statement.setBoolean(1, true);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                PreparedStatement dishesInOrderStatement = connection.prepareStatement("SELECT * FROM ORDERED_DISHES WHERE ORDER_ID = ?");
                dishesInOrderStatement.setInt(1, resultSet.getInt("id"));
                ResultSet dishesInOrderSet = dishesInOrderStatement.executeQuery();
                result.add(getOrderFromQuery(resultSet, dishesInOrderSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Order> findAllClosedOrders() {
        List<Order> result = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ORDERS WHERE IS_OPEN = ?");
            statement.setBoolean(1, false);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                PreparedStatement dishesInOrderStatement = connection.prepareStatement("SELECT * FROM ORDERED_DISHES WHERE ORDER_ID = ?");
                dishesInOrderStatement.setInt(1, resultSet.getInt("id"));
                ResultSet dishesInOrderSet = dishesInOrderStatement.executeQuery();
                result.add(getOrderFromQuery(resultSet, dishesInOrderSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Order getOrderFromQuery(ResultSet ordersSet, ResultSet dishesInOrderSet) throws SQLException {
        Order result = new Order(ordersSet.getInt("id"), ordersSet.getInt("employee_id"), ordersSet.getInt("table_number"), ordersSet.getBoolean("is_open"));
        Map<Integer, Integer> dishes = new HashMap<>();
        while (dishesInOrderSet.next()) {
            dishes.put(dishesInOrderSet.getInt("dish_id"), dishesInOrderSet.getInt("quantity"));
        }
        result.setOrderedDishes(dishes);
        return result;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}

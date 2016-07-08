package home.pdm.dao;

import home.pdm.model.Menu;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCMenuDAO implements IMenuDAO {

    private DataSource dataSource;

    @Override
    public void createMenu(Menu menu) {
        try {

            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO MENU VALUES (?,?)");
            statement.setInt(1, menu.getMenuId());
            statement.setString(2, menu.getName());
            statement.executeUpdate();
            for (Integer dish : menu.getDishes()) {
                PreparedStatement dishStatement = connection.prepareStatement("INSERT INTO DISHES_IN_MENU VALUES (?,?)");
                dishStatement.setInt(1, dish);
                dishStatement.setInt(2, menu.getMenuId());
                dishStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteMenu(String name) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM MENU WHERE MENU_NAME = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                statement = connection.prepareStatement("DELETE FROM MENU WHERE MENU_NAME = ?");
                statement.setString(1, name);
                PreparedStatement dishesInMenuStatement = connection.prepareStatement("DELETE FROM DISHES_IN_MENU WHERE MENU_ID = ?");
                dishesInMenuStatement.setInt(1, resultSet.getInt("id"));
                dishesInMenuStatement.executeUpdate();
                statement.executeUpdate();
            } else {
                throw new RuntimeException("No such menu " + name + " in database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addDishToMenu(String dishName, int menuId) {
        try {

            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM DISHES WHERE NAME = ?");
            statement.setString(1, dishName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                PreparedStatement dishesInMenu = connection.prepareStatement("INSERT INTO DISHES_IN_MENU VALUES (?,?)");
                dishesInMenu.setInt(1, resultSet.getInt("id"));
                dishesInMenu.setInt(2, menuId);
                dishesInMenu.executeUpdate();
            } else {
                throw new RuntimeException("No such dish " + dishName + " in database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeDishFromMenu(int dishID, int menuId) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM DISHES_IN_MENU WHERE DISH_ID = ? AND MENU_ID = ?");
            statement.setInt(1, dishID);
            statement.setInt(2, menuId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Menu findMenu(String name) {
        Menu result = null;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM MENU WHERE MENU_NAME = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                statement = connection.prepareStatement("SELECT * FROM DISHES_IN_MENU WHERE MENU_ID = ?");
                statement.setInt(1, resultSet.getInt("id"));
                ResultSet dishesInMenu = statement.executeQuery();
                result = getMenuFromQuery(resultSet, dishesInMenu);

            } else {
                throw new RuntimeException("No such menu " + name + " in database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Menu getMenuFromQuery(ResultSet menuSet, ResultSet dishesInMenu) throws SQLException {
        Menu result = new Menu(menuSet.getInt("id"), menuSet.getString("menu_name"));
        List<Integer> dishes = new ArrayList<>();
        while (dishesInMenu.next()) {
            dishes.add(dishesInMenu.getInt("dish_id"));
        }
        result.setDishes(dishes);
        return result;
    }

    @Override
    public List<Menu> findAllMenus() {
        List<Menu> result = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM MENU");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                statement = connection.prepareStatement("SELECT * FROM DISHES_IN_MENU WHERE MENU_ID = ?");
                statement.setInt(1, resultSet.getInt("id"));
                ResultSet dishesInMenu = statement.executeQuery();
                result.add(getMenuFromQuery(resultSet, dishesInMenu));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}

package home.pdm.dao;

import home.pdm.model.Dish;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCDishDAO implements IDishDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void createDish(Dish dish) {
        try {

            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO DISHES VALUES (?,?,?,?,?)");
            statement.setInt(1, dish.getDishId());
            statement.setString(2, dish.getName());
            statement.setString(3, dish.getCategory());
            statement.setDouble(4, dish.getCost());
            statement.setInt(5, dish.getWeight());
            statement.executeUpdate();
            for (Map.Entry<Integer, Double> ingredient : dish.getIngredients().entrySet()) {
                PreparedStatement ingredientStatement = connection.prepareStatement("INSERT INTO DISH_INGREDIENTS VALUES (?,?,?)");
                ingredientStatement.setInt(1, dish.getDishId());
                ingredientStatement.setInt(2, ingredient.getKey());
                ingredientStatement.setDouble(3, ingredient.getValue());
                ingredientStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteDish(String name) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM DISHES WHERE NAME = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                statement = connection.prepareStatement("DELETE FROM DISHES WHERE NAME = ?");
                statement.setString(1, name);
                PreparedStatement dishIngredientsStatement = connection.prepareStatement("DELETE FROM DISH_INGREDIENTS WHERE DISH_ID = ?");
                dishIngredientsStatement.setInt(1, resultSet.getInt("id"));
                dishIngredientsStatement.executeUpdate();
                statement.executeUpdate();
            } else {
                throw new RuntimeException("No such dish " + name + " in database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Dish findDish(String name) {
        Dish result = null;
        try {

            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM DISHES WHERE NAME = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                PreparedStatement dishIngredientsStatement = connection.prepareStatement("SELECT * FROM DISH_INGREDIENTS WHERE DISH_ID = ?");
                dishIngredientsStatement.setInt(1, resultSet.getInt("id"));
                ResultSet dishIngredientsResultSet = dishIngredientsStatement.executeQuery();
                result = getDishFromQuery(resultSet, dishIngredientsResultSet);
            } else {
                throw new RuntimeException("No such dish " + name + " in database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Dish> findAllDishes() {

        List<Dish> result = new ArrayList<>();
        try {

            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM DISHES");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                PreparedStatement dishIngredientsStatement = connection.prepareStatement("SELECT * FROM DISH_INGREDIENTS WHERE DISH_ID = ?");
                dishIngredientsStatement.setInt(1, resultSet.getInt("id"));
                ResultSet dishIngredientsResultSet = dishIngredientsStatement.executeQuery();
                result.add(getDishFromQuery(resultSet, dishIngredientsResultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Dish getDishFromQuery(ResultSet resultSet, ResultSet dishIngredientsResultSet) throws SQLException {

        Dish result = new Dish(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("category"), resultSet.getDouble("cost"), resultSet.getInt("weight"));
        Map<Integer, Double> ingredients = new HashMap<>();
        while (dishIngredientsResultSet.next()) {
            ingredients.put(dishIngredientsResultSet.getInt("ingredient_id"), dishIngredientsResultSet.getDouble("quantity"));
        }
        result.setIngredients(ingredients);
        return result;
    }
}

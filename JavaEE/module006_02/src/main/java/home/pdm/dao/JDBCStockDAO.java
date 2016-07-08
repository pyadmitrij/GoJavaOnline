package home.pdm.dao;

import home.pdm.model.Stock;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCStockDAO implements IStockDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addIngredient(Stock ingredient) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO STOCK VALUES (?,?)");
            statement.setInt(1, ingredient.getIngredientId());
            statement.setInt(2, ingredient.getQuantity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeIngredient(int id) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM STOCK WHERE INGREDIENT_ID = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void changeIngredientQuantity(int id, int newQuantity) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE STOCK SET QUANTITY = ? WHERE INGREDIENT_ID = ?");
            statement.setInt(1, newQuantity);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Stock findIngredient(String name) {
        Stock result = null;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM INGREDIENTS WHERE NAME = ?");
            statement.setString(1, name);
            ResultSet ingredientSet = statement.executeQuery();
            if (ingredientSet.next()) {
                statement = connection.prepareStatement("SELECT * FROM STOCK WHERE INGREDIENT_ID = ?");
                statement.setInt(1, ingredientSet.getInt("id"));
                ResultSet stockSet = statement.executeQuery();
                if (stockSet.next()) {
                    result = getIngredientFromQuery(stockSet);
                } else {
                    throw new RuntimeException("There is no " + name + " in stock right now.");
                }
            } else {
                throw new RuntimeException("There is no such ingredient" + name + " in database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Stock getIngredientFromQuery(ResultSet stockSet) throws SQLException {
        return new Stock(stockSet.getInt("ingredient_id"), stockSet.getInt("quantity"));
    }

    @Override
    public List<Stock> findAllIngredients() {
        List<Stock> result = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM  STOCK");
            ResultSet stockSet = statement.executeQuery();
            while (stockSet.next()) {
                result.add(getIngredientFromQuery(stockSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Stock> findAllThatEnds(int quantity) {
        List<Stock> result = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM  STOCK WHERE QUANTITY <= ?");
            statement.setInt(1, quantity);
            ResultSet stockSet = statement.executeQuery();
            while (stockSet.next()) {
                result.add(getIngredientFromQuery(stockSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

}

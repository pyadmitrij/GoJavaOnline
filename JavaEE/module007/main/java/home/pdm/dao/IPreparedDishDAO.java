package home.pdm.dao;

import home.pdm.model.PreparedDish;

import java.util.List;

public interface IPreparedDishDAO {

    void addPreparedDish(PreparedDish preparedDish);

    List<PreparedDish> findAllPreparedDishes();

}

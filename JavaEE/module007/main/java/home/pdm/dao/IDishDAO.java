package home.pdm.dao;

import home.pdm.model.Dish;

import java.util.List;

public interface IDishDAO {

    void createDish(Dish dish);

    void deleteDish(String name);

    Dish findDish(String name);

    Dish findDish(int id);

    List<Dish> findAllDishes();

}

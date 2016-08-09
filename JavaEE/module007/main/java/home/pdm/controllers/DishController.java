package home.pdm.controllers;

import home.pdm.dao.IDishDAO;
import home.pdm.model.Dish;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class DishController {

    private IDishDAO dishDao;

    @Transactional
    public void createDish(Dish dish) {
        dishDao.createDish(dish);
    }

    @Transactional
    public void deleteDish(String name) {
        dishDao.deleteDish(name);
    }

    @Transactional
    public Dish findDish(String name) {
        return dishDao.findDish(name);
    }

    @Transactional
    public List<Dish> findAllDishes() {
        return dishDao.findAllDishes();
    }

    public void setDishDao(IDishDAO dishDao) {
        this.dishDao = dishDao;
    }

}

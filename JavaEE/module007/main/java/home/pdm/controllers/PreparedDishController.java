package home.pdm.controllers;

import home.pdm.dao.IDishDAO;
import home.pdm.dao.IPreparedDishDAO;
import home.pdm.dao.IStockDAO;
import home.pdm.model.Dish;
import home.pdm.model.Ingredient;
import home.pdm.model.PreparedDish;
import home.pdm.model.Stock;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PreparedDishController {

    private IPreparedDishDAO preparedDishDao;
    private IDishDAO dishDao;
    private IStockDAO stockDao;

    @Transactional
    public void addPreparedDish(PreparedDish preparedDish) {
        Dish dish = dishDao.findDish(preparedDish.getDishId());
        List<Ingredient> ingredients = dish.getIngredients();
        if (ingredientsValidator(ingredients)) {
            for (Ingredient ingredient : ingredients) {
                stockDao.changeIngredientQuantity(ingredient.getIngredientId(), -1);
            }
            preparedDishDao.addPreparedDish(preparedDish);
        }
    }

    @Transactional
    private boolean ingredientsValidator(List<Ingredient> ingredients) {
        for (Ingredient ingredient : ingredients) {
            Stock currentStock = stockDao.findIngredient(ingredient.getName());
            if (currentStock.getQuantity() == 0) return false;
        }
        return true;
    }

    @Transactional
    public List<PreparedDish> findAllPreparedDishes() {
        return preparedDishDao.findAllPreparedDishes();
    }

    public void setPreparedDishDao(IPreparedDishDAO preparedDishDao) {
        this.preparedDishDao = preparedDishDao;
    }

    public void setDishDao(IDishDAO dishDao) {
        this.dishDao = dishDao;
    }

    public void setStockDao(IStockDAO stockDao) {
        this.stockDao = stockDao;
    }
}

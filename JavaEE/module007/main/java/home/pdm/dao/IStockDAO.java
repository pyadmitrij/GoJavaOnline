package home.pdm.dao;

import home.pdm.model.Stock;

import java.util.List;

public interface IStockDAO {

    void addIngredient(Stock ingredient);

    void removeIngredient(String name);

    void changeIngredientQuantity(int id, int newQuantity);

    Stock findIngredient(String name);

    List<Stock> findAllIngredients();

    List<Stock> findAllThatEnds(int quantity);

}

package home.pdm.controllers;

import home.pdm.dao.IStockDAO;
import home.pdm.model.Stock;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StockController {

    private PlatformTransactionManager txManager;
    private IStockDAO stockDao;

    @Transactional
    public void addIngredient(Stock ingredient) {
        stockDao.addIngredient(ingredient);
    }

    @Transactional
    public void removeIngredient(int id) {
        stockDao.removeIngredient(id);
    }

    @Transactional
    public void changeIngredientQuantity(int id, int newQuantity) {
        stockDao.changeIngredientQuantity(id, newQuantity);
    }

    @Transactional
    public Stock findIngredient(String name) {
        return stockDao.findIngredient(name);
    }

    @Transactional
    public List<Stock> findAllIngredients() {
        return stockDao.findAllIngredients();
    }

    @Transactional
    public List<Stock> findAllThatEnds(int quantity) {
        return stockDao.findAllThatEnds(quantity);
    }

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setStockDao(IStockDAO stockDao) {
        this.stockDao = stockDao;
    }

}

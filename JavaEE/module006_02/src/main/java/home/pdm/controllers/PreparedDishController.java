package home.pdm.controllers;

import home.pdm.dao.IPreparedDishDAO;
import home.pdm.model.PreparedDish;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PreparedDishController {

    private PlatformTransactionManager txManager;
    private IPreparedDishDAO preparedDishDao;

    @Transactional
    public void addPreparedDish(PreparedDish preparedDish) {
        preparedDishDao.addPreparedDish(preparedDish);
    }

    @Transactional
    public List<PreparedDish> findAllPreparedDishes() {
        return preparedDishDao.findAllPreparedDishes();
    }

    public void setPreparedDishDao(IPreparedDishDAO preparedDishDao) {
        this.preparedDishDao = preparedDishDao;
    }

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;

    }

}

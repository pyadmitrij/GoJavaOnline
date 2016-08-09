package home.pdm.controllers;

import home.pdm.dao.IMenuDAO;
import home.pdm.model.Menu;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class MenuController {

    private IMenuDAO menuDao;

    @Transactional
    public void createMenu(Menu menu) {
        menuDao.createMenu(menu);
    }

    @Transactional
    public void deleteMenu(String name) {
        menuDao.deleteMenu(name);
    }

    @Transactional
    public void addDishToMenu(String dishName, int menuId) {
        menuDao.addDishToMenu(dishName, menuId);
    }

    @Transactional
    public void removeDishFromMenu(int dishId, int menuId) {
        menuDao.removeDishFromMenu(dishId, menuId);
    }

    @Transactional
    public Menu findMenu(String name) {
        return menuDao.findMenu(name);
    }

    @Transactional
    public List<Menu> findAllMenus() {
        return menuDao.findAllMenus();
    }

    public void setMenuDao(IMenuDAO menuDao) {
        this.menuDao = menuDao;
    }

}

package home.pdm.hibernate;

import home.pdm.dao.IMenuDAO;
import home.pdm.model.Menu;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class HMenuDAO implements IMenuDAO {

    private SessionFactory sessionFactory;

    @Override
    public void createMenu(Menu menu) {
        sessionFactory.getCurrentSession().save(menu);
    }

    @Override
    public void deleteMenu(String name) {
        Menu menu = findMenu(name);
        sessionFactory.getCurrentSession().delete(menu);
    }

    @Override
    public void addDishToMenu(String dishName, int menuID) {

    }

    @Override
    public void removeDishFromMenu(int dishID, int menuId) {

    }

    @Override
    public Menu findMenu(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Menu e where e.name like :name");
        query.setParameter("name",name);
        return (Menu) query.uniqueResult();
    }

    @Override
    public List<Menu> findAllMenus() {
        return sessionFactory.getCurrentSession().createQuery("select o from Menu o").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}

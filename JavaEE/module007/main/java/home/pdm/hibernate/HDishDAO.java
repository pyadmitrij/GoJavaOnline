package home.pdm.hibernate;

import home.pdm.dao.IDishDAO;
import home.pdm.model.Dish;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class HDishDAO implements IDishDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(HDishDAO.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createDish(Dish dish) {
        sessionFactory.getCurrentSession().save(dish);
    }

    public void deleteDish(String name) {
        Dish dish = findDish(name);
        sessionFactory.getCurrentSession().delete(dish);
    }

    public Dish findDish(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Dish e where e.name like :name");
        query.setParameter("name", name);
        return (Dish) query.uniqueResult();
    }

    @Override
    public Dish findDish(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Dish e where e.dishId = :dishId");
        query.setParameter("id", id);
        return (Dish) query.uniqueResult();
    }

    public List<Dish> findAllDishes() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select e from Dish e").list();
    }

}

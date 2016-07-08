package home.pdm.controllers;

import home.pdm.dao.IOrderDAO;
import home.pdm.model.Order;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class OrderController {

    private PlatformTransactionManager txManager;
    private IOrderDAO orderDao;

    @Transactional
    public void createOrder(Order order) {
        orderDao.createOrder(order);
    }

    @Transactional
    public void deleteOrder(int id) {
        orderDao.deleteOrder(id);
    }

    @Transactional
    public void addDishToOrder(int orderID, int dishId, int quantity) {
        orderDao.addDishToOrder(orderID, dishId, quantity);
    }

    @Transactional
    public void removeDishFromOrder(int orderId, int dishId) {
        orderDao.removeDishFromOrder(orderId, dishId);
    }

    @Transactional
    public void closeOrder(int id) {
        orderDao.closeOrder(id);
    }

    @Transactional
    public List<Order> findAllOpenOrders() {
        return orderDao.findAllOpenOrders();
    }

    @Transactional
    public List<Order> findAllClosedOrders() {
        return orderDao.findAllClosedOrders();
    }

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setOrderDao(IOrderDAO orderDao) {
        this.orderDao = orderDao;
    }

}

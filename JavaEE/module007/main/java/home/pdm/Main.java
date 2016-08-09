package home.pdm;

import home.pdm.controllers.*;
import home.pdm.model.PreparedDish;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private DishController dishController;
    private EmployeeController employeeController;
    private MenuController menuController;
    private OrderController orderController;
    private StockController stockController;
    private PreparedDishController preparedDishController;
    private SessionFactory sessionFactory;


    public void setStockController(StockController stockController) {
        this.stockController = stockController;
    }

    public void setPreparedDishController(PreparedDishController preparedDishController) {
        this.preparedDishController = preparedDishController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app-context.xml", "hibernate-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();
    }

    public void start() {

        employeeController.findAll().forEach(System.out::println);

        preparedDishController.addPreparedDish(new PreparedDish(3,1,3,2, new Date(2016,06,27)));
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}

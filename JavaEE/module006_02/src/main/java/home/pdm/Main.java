package home.pdm;

import home.pdm.controllers.*;
import home.pdm.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private EmployeeController employeeController;
    private DishController dishController;
    private MenuController menuController;
    private OrderController orderController;
    private PreparedDishController preparedDishController;
    private StockController stockController;

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
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();
    }

    public void start() {

        employeeController.findAll().forEach(System.out::println);
    }
}

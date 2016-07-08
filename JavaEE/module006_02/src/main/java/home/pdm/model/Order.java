package home.pdm.model;

import java.util.Map;

public class Order {

    private int orderId;
    private int employeeId;
    private int tableNumber;
    private boolean isOpen;
    private Map<Integer, Integer> orderedDishes;

    public Order(int id, int employeeId, int tableNumber, boolean isOpen) {
        this.orderId = id;
        this.employeeId = employeeId;
        this.tableNumber = tableNumber;
        this.isOpen = isOpen;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public Map<Integer, Integer> getOrderedDishes() {
        return orderedDishes;
    }

    public void setOrderedDishes(Map<Integer, Integer> orderedDishes) {
        this.orderedDishes = orderedDishes;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", employeeId=" + employeeId +
                ", tableNumber=" + tableNumber +
                ", isOpen=" + isOpen +
                ", orderedDishes=" + orderedDishes +
                '}';
    }

}

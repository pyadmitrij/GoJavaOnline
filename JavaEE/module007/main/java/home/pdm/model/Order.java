package home.pdm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Map;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "table_number")
    private int tableNumber;

    @Column(name = "is_open")
    private boolean isOpen;

    public Order(){}

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


    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", employeeId=" + employeeId +
                ", tableNumber=" + tableNumber +
                ", isOpen=" + isOpen +
                '}';
    }

}

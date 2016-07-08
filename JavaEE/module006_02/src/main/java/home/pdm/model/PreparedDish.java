package home.pdm.model;

import java.sql.Date;

public class PreparedDish {

    private int id;
    private int dishId;
    private int employeeId;
    private int orderId;
    private Date date;

    public PreparedDish(int id, int dishId, int employeeId, int orderId, Date date) {
        this.id = id;
        this.dishId = dishId;
        this.employeeId = employeeId;
        this.orderId = orderId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PreparedDish{" +
                "id=" + id +
                ", dishId=" + dishId +
                ", employeeId=" + employeeId +
                ", orderId=" + orderId +
                ", date=" + date +
                '}';
    }
}

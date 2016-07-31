package home.pdm.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Waiter extends Employee {

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Waiter{");
        result.append("id = ");
        result.append(this.getEmployeeId());
        result.append(", surname = ");
        result.append(this.getFirstName());
        result.append('\'');
        result.append(", name = ");
        result.append(this.getLastName());
        result.append('\'');
        result.append(", birthDate = ");
        result.append(this.getBirthDate());
        result.append(", phone = ");
        result.append(this.getPhone());
        result.append('\'');
        result.append(", salary=");
        result.append(this.getSalary());
        result.append(", orders=");
        result.append(orders);
        result.append('}');
        return result.toString();
    }
}
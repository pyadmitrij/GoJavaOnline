package home.pdm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @Column(name = "ingredient_id")
    private Integer ingredientId;

    @Column(name = "quantity")
    private Integer quantity;

    public Stock(){}

    public Stock(int ingredientId, int quantity) {
        this.ingredientId = ingredientId;
        this.quantity = quantity;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "ingredientId=" + ingredientId +
                ", quantity=" + quantity +
                '}';
    }
}

package home.pdm.model;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "dishes")
public class Dish {

    @Id
    @Column(name = "dish_id")
    private Integer dishId;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "weight")
    private Integer weight;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "DISH_INGREDIENTS",
            joinColumns = @JoinColumn(name = "dish_ID"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<Ingredient> ingredients;

    public Dish(){}

    public Dish(Integer dishId, String name, String category, double cost, int weight) {
        this.dishId = dishId;
        this.name = name;
        this.category = category;
        this.cost = cost;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dishId=" + dishId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", cost=" + cost +
                ", weight=" + weight +
                ", ingredients=" + ingredients +
                '}';
    }
}

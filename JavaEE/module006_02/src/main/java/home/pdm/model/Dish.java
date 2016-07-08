package home.pdm.model;

import java.util.Map;

public class Dish {

    private Integer dishId;
    private String name;
    private String category;
    private double cost;
    private int weight;
    private Map<Integer, Double> ingredients;

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

    public Map<Integer, Double> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<Integer, Double> ingredients) {
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

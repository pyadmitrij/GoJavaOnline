package home.pdm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INGREDIENTS")
public class Ingredient {

    @Id
    @Column(name = "ingredient_id")
    private Integer ingredientId;

    @Column(name = "name")
    private String name;

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

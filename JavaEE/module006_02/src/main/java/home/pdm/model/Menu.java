package home.pdm.model;

import java.util.List;

public class Menu {

    private int menuId;
    private String name;
    private List<Integer> dishes;

    public List<Integer> getDishes() {
        return dishes;
    }

    public void setDishes(List<Integer> dishes) {
        this.dishes = dishes;
    }

    public Menu(int id, String name) {
        this.menuId = id;
        this.name = name;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", name='" + name + '\'' +
                ", dishes=" + dishes +
                '}';
    }

}

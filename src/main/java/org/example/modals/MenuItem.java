package org.example.modals;

import org.example.modals.enums.Category;

public class MenuItem {
    private String name;
    private double price;
    private boolean isVeg;
    private Category category;

    public MenuItem(String name, double price, boolean isVeg, Category catagory) {
        this.name = name;
        this.price = price;
        this.isVeg = isVeg;
        this.category = catagory;
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isVeg() {
        return isVeg;
    }

    public Category getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setVeg(boolean veg) {
        isVeg = veg;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format("%s (%.2f) [%s, %s]", name, price, isVeg ? "Veg" : "Non-Veg", category);
    }

}

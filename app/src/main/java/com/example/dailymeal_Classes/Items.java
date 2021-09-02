package com.example.dailymeal_Classes;

public class Items {
    private String id;
    private String category;
    private String name;
    private int price;
    private int drawable_id;
    private String description;

    public Items(String id, String category, String name, int price, int drawable_id, String description) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.drawable_id = drawable_id;
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDrawable_id() {
        return drawable_id;
    }

    public void setDrawable_id(int drawable_id) {
        this.drawable_id = drawable_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

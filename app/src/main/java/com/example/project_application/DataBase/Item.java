package com.example.project_application.DataBase;

public class Item {
    private int id;
    private String title;
    private String type;
    private String price;

    public int getId() { return id; }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

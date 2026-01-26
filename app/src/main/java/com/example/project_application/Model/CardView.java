package com.example.project_application.Model;

public class CardView {

    private String title;

    private String category;

    private String price;

    public CardView(String title,
                    String category,
                    String price) {
        this.title = title;
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public String getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

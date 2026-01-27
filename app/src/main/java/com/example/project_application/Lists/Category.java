package com.example.project_application.Lists;

import com.example.project_application.ModelUi.CategoryButton;

import java.util.Arrays;
import java.util.List;

public class Category {

    List<CategoryButton> list = Arrays.asList(new CategoryButton("Популярное"),
            new CategoryButton("Женщинам"),
            new CategoryButton("Мужчинам"),
            new CategoryButton("Детям"),
            new CategoryButton("Аксессуары"));

    public List<CategoryButton> getList() {
        return list;
    }

}

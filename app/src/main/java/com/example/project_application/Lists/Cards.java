package com.example.project_application.Lists;

import com.example.project_application.Model.CardView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cards {

    private List<CardView> allList = new ArrayList<>() ;
    private List<CardView> womenList = Arrays.asList(new CardView("Рубашка Воскресенье для машинного вязания", "Женская одежда", "300₽"),
            new CardView("Рубашка Воскресенье для машинного вязания", "Женская одежда", "300₽")) ;

    private List<CardView> menList=Arrays.asList(new CardView("Рубашка Воскресенье для машинного вязания", "Мужская одежда", "300₽"),
            new CardView("Рубашка Воскресенье для машинного вязания", "Мужская одежда", "300₽"));

    private List<CardView> childList = Arrays.asList(new CardView("Рубашка Воскресенье для машинного вязания", "Детская одежда", "300₽"),
            new CardView("Рубашка Воскресенье для машинного вязания", "Детская одежда", "300₽"));

    private List<CardView> accsList = Arrays.asList(new CardView("Рубашка Воскресенье для машинного вязания", "Аксессуары", "300₽"),
            new CardView("Рубашка Воскресенье для машинного вязания", "Аксессуары", "300₽"));

    {
        allList.addAll(womenList);
        allList.addAll(menList);
        allList.addAll(childList);
        allList.addAll(accsList);
    }

    public List<CardView> getAllList() {
        return allList;
    }

    public List<CardView> getWomenList() {
        return womenList;
    }

    public List<CardView> getMenList() {
        return menList;
    }

    public List<CardView> getChildList() {
        return childList;
    }

    public List<CardView> getAccsList() {
        return accsList;
    }
}

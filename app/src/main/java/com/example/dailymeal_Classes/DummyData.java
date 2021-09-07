package com.example.dailymeal_Classes;

import com.example.dailymeal.R;

import java.util.ArrayList;

public class DummyData {

    public static ArrayList<Items> items;

    public DummyData() {
        this.items = initializeDummyData();
    }

    public static ArrayList<Items> initializeDummyData() {
        items = new ArrayList<Items>();

        items.add(new Items("img_ff_1", "FastFood", "Nuggets Deal", 123 ,R.drawable.img_ff_1,  "8  Nuggets, 1 Fries and 1 Drink"));
        items.add(new Items("img_ff_2", "FastFood", "Wings Deal", 495 ,R.drawable.img_ff_2,  "15 Chicken Wings and 2 Drinks"));
        items.add(new Items("img_ff_3", "FastFood", "Zinger Burger", 500 ,R.drawable.img_ff_3,  " 1 Zinger Burger, Fries and Drink"));
        items.add(new Items("img_ff_4", "FastFood", "Pizza Deal", 1250 ,R.drawable.img_ff_4,  "1 Medium Pizza, 2 Zinger Burgers and 1 litre Coac"));
        items.add(new Items("img_ff_5", "FastFood", "Pan Pizza", 560 ,R.drawable.img_ff_5,  "1 Small Pizza and 2 Half Litre Bottle"));
        items.add(new Items("img_ff_6", "FastFood", "Hot Shots", 370 ,R.drawable.img_ff_6,  "10 Hot Shots"));
        items.add(new Items("img_ff_7", "FastFood", "Mega Deal", 2250 ,R.drawable.img_ff_7,  "1 Large Pizza, 1 Zinger Burger, Fries and 1 Litre Coac"));
        items.add(new Items("img_if_1", "Italian", "Burger", 650 ,R.drawable.img_if_1,  "Italian Burger and Fries"));
        items.add(new Items("img_if_2", "Italian", "Zinger Burgers", 675 ,R.drawable.img_if_2,  "3 Italian Burgers"));
        items.add(new Items("img_if_3", "Italian", "Shawarma", 670 ,R.drawable.img_if_3,  "3 Italian Shawarmas"));
        items.add(new Items("img_if_4", "Italian", "Noodles", 250 ,R.drawable.img_if_4,  "Italian Noodles"));
        items.add(new Items("img_if_5", "Italian", "Lazanya", 1250 ,R.drawable.img_if_5,  "1 Italian Lazanay"));
        items.add(new Items("img_if_6", "Italian", "Pizza", 340 ,R.drawable.img_if_6,  "1 Italian Pizza"));
        items.add(new Items("img_if_7", "Italian", "Pasta", 750 ,R.drawable.img_if_7,  "1 Italian Pasta"));
        items.add(new Items("img_if_8", "Italian", "Chicken Pasta", 850 ,R.drawable.img_if_8,  "Italian Chicken Pasta"));
        items.add(new Items("img_if_10", "Italian", "Meat", 1250 ,R.drawable.img_if_10,  "Italian Meat"));
        items.add(new Items("img_cf_1", "Chinese", "Chinese Meat", 950 ,R.drawable.img_cf_1,  "Chinese Meat"));
        items.add(new Items("img_cf_2", "Chinese", "Chinese Rice", 1250 ,R.drawable.img_cf_2,  "1 Chinese Rice Dish"));
        items.add(new Items("img_cf_3", "Chinese", "Chinese Shrimp", 2750 ,R.drawable.img_cf_3,  "Chinese Shrimp Dish"));
        items.add(new Items("img_cf_4", "Chinese", "Chinese Legs", 950 ,R.drawable.img_cf_4,  "Chinese Legs"));
        items.add(new Items("img_cf_5", "Chinese", "Chinese Soup", 250 ,R.drawable.img_cf_5,  "1 Bowl Of Chinese Soup"));
        items.add(new Items("img_cf_6", "Chinese", "Special Chinese Shrimp", 250 ,R.drawable.img_cf_6,  "Chinese Shrimp With Special Soup"));
        items.add(new Items("img_cf_7", "Chinese", "Chinese Sweet", 250 ,R.drawable.img_cf_7,  "Chinese Sweet Rice With Special Colours"));
        items.add(new Items("img_cf_8", "Chinese", "Chinese Candy", 250 ,R.drawable.img_cf_8,  "5 Special Chinese Candy"));
        items.add(new Items("img_cf_9", "Chinese", "Chinese Box Noodels", 250 ,R.drawable.img_cf_9,  "Chinese Special Chowmein Noddles"));

        return items;
    }


    public static ArrayList<Items> getItems() {
        return items;
    }

    public static void setItems(ArrayList<Items> items) {
        items = items;
    }
}

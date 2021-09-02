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

        items.add(new Items("img_deal_1", "FastFood", "Zinger Burger", 123 ,R.drawable.img_deal_1,  "This is a Zinger Burger"));
        items.add(new Items("img_deal_2", "FastFood", "Paratha Roll", 223 ,R.drawable.img_deal_2,  "kjsdhfajkl aklsdjf klsadjfklasd jaskld jfasl jkdf"));
        items.add(new Items("img_deal_3", "FastFood", "Zinger Burger", 500 ,R.drawable.img_deal_3,  " asdjhfuery tui3489r fkawjhefi3 fjkcasdh fiu"));
        items.add(new Items("img_deal_4", "FastFood", "Zinger Burger", 125 ,R.drawable.img_deal_4,  "ksdjafkl jasdklfj a"));
        items.add(new Items("img_deal_5", "FastFood", "Zinger Burger", 250 ,R.drawable.img_deal_5,  "asdj hfajklhder8o34 rjiosj"));

        return items;
    }

    public static ArrayList<Items> getItems() {
        return items;
    }

    public static void setItems(ArrayList<Items> items) {
        items = items;
    }
}

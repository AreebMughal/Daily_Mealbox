package com.example.dailymeal;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dailymeal_Classes.DummyData;
import com.example.dailymeal_Classes.Items;

import java.util.ArrayList;

public class ItemDetailActivity extends AppCompatActivity {

    TextView txt_quantity, txt_price, txt_description, txt_foodname;
    ImageView image_food, img_fav;
    int count = 0;
    int id;
    ArrayList<Items> items;

    boolean checkIcon = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        initializeComponents();

        Bundle bundle = getIntent().getExtras();
        id = bundle.getInt("id");
        items = DummyData.getItems();

        loadData();

    }

    public void toggleIcon(View view) {
        if (checkIcon == false) {
            checkIcon = true;
            img_fav.setImageResource(R.drawable.ic_red);
        } else {
            img_fav.setImageResource(R.drawable.ic_fav);
            checkIcon = false;
        }
    }

    private void initializeComponents() {
        txt_quantity = findViewById(R.id.txt_quantity);
        txt_foodname = findViewById(R.id.txt_foodName);
        txt_price = findViewById(R.id.txt_price);
        txt_description = findViewById(R.id.txt_description);
        image_food = findViewById(R.id.image_food);
        img_fav = findViewById(R.id.img_fav);
    }

    private void loadData() {
        int index = getIndex();
        if (index >= 0) {
            Items item = items.get(index);
            txt_foodname.setText(item.getName());
            txt_price.setText(String.valueOf(item.getPrice()));
            txt_description.setText(item.getDescription());
            image_food.setImageResource(item.getDrawable_id());
        }
    }

    private int getIndex() {
        int index = 0;
        for (Items i : items) {
            if (i.getDrawable_id() == id)
                return index;
            index++;
        }
        return -1;
    }


    public void increment(View v) {
        count++;
        txt_quantity.setText("" + count);
    }

    public void decrement(View v) {
        if (count <= 0) {
            count = 0;
        } else {
            count--;
            txt_quantity.setText("" + count);
        }
    }
}

package com.example.dailymeal;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailActivity extends AppCompatActivity {

    TextView value;
    int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        value = (TextView) findViewById(R.id.txt_quantity);
    }

    public void increment(View v) {
        count++;
        value.setText("" + count);
    }

    public void decrement(View v) {
        if (count <= 0) {
            count = 0;
        } else {
            count--;
            value.setText("" + count);
        }
    }
}

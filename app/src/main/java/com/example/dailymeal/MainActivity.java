package com.example.dailymeal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.viewpager.widget.ViewPager;

import com.example.dailymeal_Classes.AlertDialogue;
import com.example.dailymeal_Classes.CheckInternet;
import com.example.dailymeal_Classes.DummyData;
import com.example.dailymeal_Classes.ImageAdapter;


public class MainActivity extends BaseActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.addContentView(R.layout.main_content);
        super.setItemChecked(R.id.nav_home);
        try {
            ViewPager viewPager = findViewById(R.id.viewPager);
            ImageAdapter adapter = new ImageAdapter(this);
            viewPager.setAdapter(adapter);
        } catch (Exception e) {
            (new AlertDialogue(this)).printMsg(e);
        }
        if (CheckInternet.isInternetConnection(this)) {
            Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Not Connected", Toast.LENGTH_SHORT).show();
        }

        DummyData.initializeDummyData();


//        try {
//            if (LoggedInUser.getUserId() != null) {
//                ((TextView) findViewById(R.id.txt_header_name)).setText(LoggedInUser.getDisplayName());
//                (new AlertDialogue(this)).printMsg(LoggedInUser.getDisplayName());
//            }
//            else {
//                ((TextView) findViewById(R.id.txt_header_name)).setText("Daily Meal");
//                (new AlertDialogue(this)).printMsg("LoggedInUser.getDisplayName()");
//            }
//        } catch (Exception e) {
//            (new AlertDialogue(this)).printMsg(e);
//        }

    }

    public void hello(View view) {
        try {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        } catch (Exception e) {
            (new AlertDialogue(this)).printMsg(e);
        }
    }

    public void openAll(View view) {

    }

    public void openDetailActivity(View view) {
        AlertDialogue alert = (new AlertDialogue(this));

        try {
            ImageView imageView = findViewById(view.getId());
            String imageName = imageView.getTag().toString();
            int id = this.getResources().getIdentifier(imageName, "drawable", this.getPackageName());

            Intent intent = new Intent(this, ItemDetailActivity.class);
            intent.putExtra("id", id);
            startActivity(intent);
        } catch (Exception e) {
            alert.printMsg(e);
        }
    }

}
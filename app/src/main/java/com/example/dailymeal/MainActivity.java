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
import com.smarteist.autoimageslider.SliderView;

import java.util.Timer;


public class MainActivity extends BaseActivity {

    SliderView sliderView;
    int [] image = {R.drawable.s1,
            R.drawable.s2,
            R.drawable.s3,
            R.drawable.s4,
            R.drawable.s1,
    };
    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.addContentView(R.layout.main_content);
        super.setItemChecked(R.id.nav_home);

//        sliderView = findViewById(R.id.slider);
//
//        SliderAdopter sliderAdopter = new SliderAdopter(image);
//
//        sliderView.setSliderAdapter(sliderAdopter);
//        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
//        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
//        sliderView.startAutoCycle();



        try {
            ViewPager viewPager = findViewById(R.id.viewPager);
            ImageAdapter adapter = new ImageAdapter(this);
            viewPager.setAdapter(adapter);
            for (int i = 0; i < adapter.getCount()-1; i++)
                viewPager.setCurrentItem(i, true);
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
        Intent intent = new Intent(this,ThumbnailActivity.class);
        intent.putExtra("category", (findViewById(view.getId())).getTag().toString() );
        startActivity(intent);
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
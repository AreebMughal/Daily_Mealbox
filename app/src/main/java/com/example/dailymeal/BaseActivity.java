package com.example.dailymeal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.dailymeal.data.model.LoggedInUser;
import com.example.dailymeal_Classes.AlertDialogue;
import com.google.android.material.navigation.NavigationView;

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);

        toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);
        checkHeaderTitle();
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void addContentView(int layoutId) {
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(layoutId, null, false);
        drawer.addView(contentView, 0);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        drawer.closeDrawers();

        switch (item.getItemId()) {
            case R.id.nav_home:
                callActivity(MainActivity.class);
                break;
            case R.id.nav_prof:
                if (LoggedInUser.getDisplayName() == null)
                    startActivity(new Intent(this, LoginActivity.class));
                else
                    startActivity(new Intent(this, ProfileActivity.class));
                break;
            case R.id.nav_fav:
//                callActivity(ItemDetailActivity.class);
                break;
            case R.id.nav_plan:
                break;
            case R.id.nav_category:
//                callActivity(ThumbnailActivity.class);
                break;
            case R.id.nav_logout:
                LoggedInUser.removeUser();
                callActivity(MainActivity.class);
                break;
            default:
                break;
        }
        return true;
    }

    private void callActivity(Class myClass) {
        startActivity(new Intent(this, myClass));
        finish();
    }

    public void setItemChecked(int id) {
        navigationView.setCheckedItem(id);
    }

    protected void checkHeaderTitle() {
        try {
            View headerView = navigationView.getHeaderView(0);
            TextView txt = headerView.findViewById(R.id.txt_header_name);

            if (LoggedInUser.getDisplayName() != null ) {
                txt.setText(LoggedInUser.getDisplayName());
            }
            else {
                txt.setText("Daily Meal");
            }
        } catch (Exception e) {
            (new AlertDialogue(this)).printMsg(e);
        }
    }
}

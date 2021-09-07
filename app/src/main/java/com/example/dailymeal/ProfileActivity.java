package com.example.dailymeal;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dailymeal.data.model.LoggedInUser;

public class ProfileActivity extends AppCompatActivity {

    TextView txt_name, txt_email, txt_address, txt_username, txt_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initializeComponents();
        loadData();
    }

    private void initializeComponents() {
        try {
            txt_name = findViewById(R.id.txt_prof_name);
            txt_username = findViewById(R.id.txt_prof_uname);
            txt_email = findViewById(R.id.txt_prof_email);
            txt_address = findViewById(R.id.txt_prof_address);
            txt_phone = findViewById(R.id.txt_prof_phone);
        } catch (Exception e) {
            (new AlertDialog.Builder(this)).setMessage(e.toString()).show();
        }
    }

    private void loadData() {
        txt_name.setText(LoggedInUser.getDisplayName());
        txt_username.setText(LoggedInUser.getUserId());
        txt_email.setText(LoggedInUser.getEmail());
        txt_phone.setText(LoggedInUser.getPhone());
//        txt_address.setText(LoggedInUser.getAddress());
    }

}

package com.example.dailymeal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dailymeal_Classes.AlertDialogue;
import com.example.dailymeal_Classes.CheckInternet;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.addContentView(R.layout.main_content);
        super.setItemChecked(R.id.nav_home);
        super.checkHeaderTitle();

        if (CheckInternet.isInternetConnection(this)) {
            Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Not Connected", Toast.LENGTH_SHORT).show();
        }

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
        } catch (Exception e)
        {
            (new AlertDialogue(this)).printMsg(e);
        }
    }

}
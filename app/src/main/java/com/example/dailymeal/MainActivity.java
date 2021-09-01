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
        if (CheckInternet.isInternetConnection(this)) {
            Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Not Connected", Toast.LENGTH_SHORT).show();
        }

    }

    public void hello(View view) {
        try {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        } catch (Exception e)
        {
            (new AlertDialogue(this)).printMsg(e);
        }
    }

}
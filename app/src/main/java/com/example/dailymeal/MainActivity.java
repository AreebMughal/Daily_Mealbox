package com.example.dailymeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputEditText edtxt_uname;
    TextInputEditText edtxt_pass;
    TextInputLayout txt_pass;
    TextInputLayout txt_uname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        edtxt_uname = findViewById(R.id.edtxt_uname);
        edtxt_pass = findViewById(R.id.edtxt_pass);

        txt_pass = findViewById(R.id.txt_pass);
        txt_uname = findViewById(R.id.txt_uname);

        edtxt_uname.addTextChangedListener(myListner);

        edtxt_pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (edtxt_pass.length() > 0)
                    txt_pass.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private TextWatcher myListner = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (edtxt_uname.length() > 0)
                txt_uname.setError(null);
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    };

    public void openSignup(View view) {
        startActivity(new Intent(this, signup.class));
    }
    public void login(View view) {

        if (!isEmpty()) {
            Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();
            background bg = new background(this);
            bg.execute(edtxt_uname.getText().toString(), edtxt_pass.getText().toString());
        }
    }

    private boolean isEmpty() {
        boolean bool = true;
        if (edtxt_uname.getText().length() == 0)
            txt_uname.setError("This field is required!");
        else if (edtxt_pass.getText().length() == 0)
            txt_pass.setError("This field is required!");
        else
            bool = false;
        return bool;
    }


    public boolean isInternetConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            return true;
        } else
            return false;
    }
}
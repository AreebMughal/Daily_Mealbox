package com.example.dailymeal;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.dailymeal.data.model.LoggedInUser;
import com.example.dailymeal_Classes.AlertDialogue;
import com.example.dailymeal_Classes.CheckInternet;
import com.example.dailymeal_Classes.User;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends BaseActivity {
    TextInputEditText edtxt_uname, edtxt_pass;
    TextInputLayout txt_pass, txt_uname;
    AlertDialogue alert;
    DatabaseReference db = FirebaseDatabase.getInstance().getReferenceFromUrl("https://dailymeal-217f8-default-rtdb.firebaseio.com/");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.addContentView(R.layout.activity_login);
        super.setItemChecked(R.id.nav_prof);

        edtxt_uname = findViewById(R.id.edtxt_uname);
        edtxt_pass = findViewById(R.id.edtxt_pass);

        txt_pass = findViewById(R.id.txt_pass);
        txt_uname = findViewById(R.id.txt_uname);

        edtxt_uname.addTextChangedListener(generalTextWatcher(edtxt_uname, txt_uname));
        edtxt_pass.addTextChangedListener(generalTextWatcher(edtxt_pass, txt_pass));

        alert = new AlertDialogue(this);
    }

    public void login(View view) {
        if (CheckInternet.isInternetConnection(this)) {
            if (!isEmpty()) {
//                alert.printMsg(username);
                String username = edtxt_uname.getText().toString();
                Query query = db.child("Users").child(username);
//                Query query = FirebaseDatabase.getInstance().getReference("Users").orderByChild("uname").equalTo(username);
                query.addListenerForSingleValueEvent(fetchDataFromDb(username));
//                Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private ValueEventListener fetchDataFromDb(String username) {
        return new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                try {
                    if (snapshot.exists()) {
                        String password = snapshot.child("password").getValue().toString();
                        if (password.equals(edtxt_pass.getText().toString())) {
                            User user = new User();
                            user.setName(snapshot.child("name").getValue().toString());
                            user.setUname(username);
                            user.setPassword(null);
                            LoggedInUser.setUserId(username);
                            LoggedInUser.setDisplayName(user.getName());
                            LoginActivity.super.checkHeaderTitle();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();
                        } else
                            setAlertMsg("Invalid Username/Password!");
                    } else
                        setAlertMsg("Invalid Username/Password!");
                } catch (Exception e) {
                    alert.printMsg(e);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                alert.printMsg("Error while reading" + error);
            }
        };
    }

    private void setAlertMsg(String msg) {
        CountDownTimer timer = myTimer(2000, 1000, msg);
        timer.start();
    }

    private CountDownTimer myTimer(int millisInFuture, int countDownInterval, String msg) {
        TextView txtview = findViewById(R.id.txt_alert);
        txtview.setText(msg);
        return new CountDownTimer(millisInFuture, countDownInterval) {
            @Override
            public void onTick(long l) {
                txtview.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFinish() {
                txtview.setVisibility(View.INVISIBLE);
            }
        };
    }

    public void openSignup(View view) {
        startActivity(new Intent(this, SignupActivity.class));
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

    public TextWatcher generalTextWatcher(TextInputEditText edtxtview, TextInputLayout txtview) {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (edtxtview.length() > 0)
                    txtview.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        };
    }
}

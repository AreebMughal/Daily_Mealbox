package com.example.dailymeal;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.example.dailymeal_Classes.AlertDialogue;
import com.example.dailymeal_Classes.CheckInternet;
import com.example.dailymeal_Classes.User;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignupActivity extends BaseActivity {

//    private static final String url = "http://204.2.63.80:18662/mealbox";
//    private static final String user = "admin";
//    private static final String pass = "areeb123";

    DatabaseReference db = FirebaseDatabase.getInstance().getReferenceFromUrl("https://dailymeal-217f8-default-rtdb.firebaseio.com/");
    TextInputEditText edtxt_name, edtxt_username, edtxt_password, edtxt_cpass;
    TextInputLayout txt_cpass, txt_name, txt_password, txt_username;

    AlertDialogue alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.addContentView(R.layout.activity_signup);
        super.setItemChecked(R.id.nav_prof);

        FirebaseApp firebaseApp = FirebaseApp.initializeApp(this);

        initializeComponents();
        initializeTextWatcher();
        alert = new AlertDialogue(this);
    }

    private void initializeComponents() {
        try {
            edtxt_name = findViewById(R.id.edtxt_name);
            edtxt_username = findViewById(R.id.edtxt_username);
            edtxt_password = findViewById(R.id.edtxt_password);
            edtxt_cpass = findViewById(R.id.edtxt_cpass);

            txt_name = findViewById(R.id.txt_name);
            txt_username = findViewById(R.id.txt_username);
            txt_password = findViewById(R.id.txt_password);
            txt_cpass = findViewById(R.id.txt_cpass);
        } catch (Exception e) {
            (new AlertDialog.Builder(this)).setMessage(e.toString()).show();
        }
    }

    private void initializeTextWatcher() {
        try {
            edtxt_name.addTextChangedListener(generalTextWatcher(edtxt_name, txt_name));
            edtxt_username.addTextChangedListener(generalTextWatcher(edtxt_username, txt_username));
            edtxt_password.addTextChangedListener(generalTextWatcher(edtxt_password, txt_password));
            edtxt_cpass.addTextChangedListener(generalTextWatcher(edtxt_cpass, txt_cpass));
        } catch (Exception e) {
            (new AlertDialogue(this)).printMsg(e);
        }
    }

    public void openLogin(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void Register(View view) {
        if (CheckInternet.isInternetConnection(this)) {
            if (!isEmpty() && checkPassword())
                try {
                    db.child("Users").addListenerForSingleValueEvent(addFirebaseValueListener());
                } catch (Exception e) {
                    alert.printErrorMsg(e);
                }
            Toast.makeText(this, "Successfully registered", Toast.LENGTH_LONG).show();
//            finish();
        } else
            alert.printErrorBtnMsg("Please Connect Internet");
    }

    private ValueEventListener addFirebaseValueListener() {
        User user = new User(edtxt_name.getText().toString(), edtxt_username.getText().toString(), edtxt_password.getText().toString());

        return new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChild(user.getUname())) {
                    txt_username.setError("*This username is already taken.");
                } else {
                    txt_username.setError(null);
                    db.child("Users").child(edtxt_username.getText().toString()).setValue(user);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                alert.printErrorMsg(error);
            }
        };
    }

    private boolean checkPassword() {
        return (checkpassLength() && matchPassowrd());
    }

    private boolean isEmpty() {
        String msg = "*This field is required!";
        if (edtxt_name.getText().length() == 0)
            txt_name.setError(msg);
        else if (edtxt_username.getText().length() == 0)
            edtxt_username.setError(msg);
        else if (edtxt_password.getText().length() == 0)
            txt_password.setError(msg);
        else if (edtxt_cpass.getText().length() == 0)
            txt_cpass.setError(msg);
        else
            return false;
        return true;
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
                if (edtxtview == edtxt_password) {
                    if (!checkpassLength())
                        txtview.setError("*Password Length should be between 5 to 10.");
                    else
                        txtview.setError(null);
                }
                if (edtxtview == edtxt_cpass) {
                    if (!matchPassowrd()) {
                        txtview.setError("*Password not match.");

                    }
                    else
                        txtview.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        };
    }

    private boolean matchPassowrd() {
        return (edtxt_password.getText().toString().equals(edtxt_cpass.getText().toString()));
    }

    private boolean checkpassLength() {
        return (edtxt_password.getText().length() >= 5 && edtxt_password.getText().length() <= 10);
    }

}


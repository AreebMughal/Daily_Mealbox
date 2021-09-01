package com.example.dailymeal;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends BaseActivity {
    TextInputEditText edtxt_uname, edtxt_pass;
    TextInputLayout txt_pass, txt_uname;

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
    }

    public void login(View view) {
        if (!isEmpty()) {
            Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();

        }
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

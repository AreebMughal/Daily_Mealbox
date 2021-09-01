package com.example.dailymeal_Classes;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

import com.example.dailymeal.R;

public class AlertDialogue {
    static AlertDialog.Builder b;

    public AlertDialogue(Context context) {
        this.b = new AlertDialog.Builder(context);
    }

    public void printErrorMsg(Object obj) {
        b.setTitle("Error");
        b.setIcon(R.drawable.ic_error);
        runBuilder(obj);
    }

    public void printMsg(Object obj) {
        b.setTitle("Message");
//        b.setIcon(R.drawable.ic_error);
        runBuilder(obj);
    }

    private void runBuilder(Object obj) {
        b.setMessage(obj.toString());
        b.show();
    }

    public void printErrorBtnMsg(Object obj) {
        b.setTitle("Error");
//        b.setIcon(R.drawable.ic_error);
        b.setPositiveButton("Ok", null);
        runBuilder(obj);
    }

}

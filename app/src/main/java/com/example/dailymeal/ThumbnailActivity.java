package com.example.dailymeal;

import android.os.Bundle;

public class ThumbnailActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.addContentView(R.layout.activity_thumbnail);
    }
}

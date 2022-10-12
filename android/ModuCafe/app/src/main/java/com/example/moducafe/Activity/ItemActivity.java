package com.example.moducafe.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moducafe.R;

public class ItemActivity extends AppCompatActivity {

    private String itemName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        getData();
        setData();
        bindingView();
        setButtonClickEvent();
    }

    private void getData() {
        Intent intent = getIntent();
        itemName = intent.getStringExtra("itemName");
    }

    private void setData() {
    }

    private void bindingView() {
        setTitle(itemName);
    }

    private void setButtonClickEvent() {
    }
}
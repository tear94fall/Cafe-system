package com.example.moducafe.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moducafe.R;

public class OrderActivity extends AppCompatActivity {

    private String orderNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        getData();
        setData();
        bindingView();
        setButtonClickEvent();
    }

    private void getData() {
        Intent intent = getIntent();
        orderNumber = intent.getStringExtra("orderNumber");
    }

    private void setData() {
    }

    private void bindingView() {
        setTitle(orderNumber);
    }

    private void setButtonClickEvent() {
    }
}
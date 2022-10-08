package com.example.moducafe.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moducafe.R;

public class ShoppingCartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        bindingView();
        getData();
        setData();
        setButtonClickEvent();
    }

    private void bindingView() {
        setTitle(getString(R.string.shopping_cart));
    }

    private void getData() {
    }

    private void setData() {
    }

    private void setButtonClickEvent() {
    }
}

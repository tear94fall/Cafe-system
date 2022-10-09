package com.example.moducafe.Activity;

import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moducafe.R;

public class ItemPopupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_item_popup);

        bindingView();
        getData();
        setData();
        setButtonClickEvent();
    }

    private void setData() {

    }

    private void getData() {

    }

    private void bindingView() {
    }

    private void setButtonClickEvent() {
    }
}
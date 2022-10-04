package com.example.moducafe.Fragments;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.moducafe.R;

public class FragmentHome extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("DEBUG", "onCreate of FragmentHome");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        setHasOptionsMenu(true);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindingView(view);
        getData();
        setData();
        setButtonClickEvent();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("DEBUG", "onResume of FragmentHome");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("DEBUG", "onPause of FragmentHome");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("DEBUG", "onStop of FragmentHome");
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void bindingView(View view) {
        LinearLayout itemCategoryView = view.findViewById(R.id.viewCategoryNames);
        buildCategoryScroll(itemCategoryView);
    }

    private void getData() {

    }

    private void setData() {

    }

    private void setButtonClickEvent() {

    }

    private void buildCategoryScroll(LinearLayout itemCategoryView) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        for (int i = 0; i < 5; i++) {
            Button categoryButton = new Button(requireActivity());

            GradientDrawable buttonShape = new GradientDrawable();
            buttonShape.setShape(GradientDrawable.RECTANGLE);
            buttonShape.setColor(ContextCompat.getColor(requireContext(), R.color.pastel_green_middle));
            buttonShape.setCornerRadius(15);

            categoryButton.setText(String.valueOf(i));
            categoryButton.setTextSize(16f);
            categoryButton.setAllCaps(false);
            categoryButton.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.pastel_green_bright));
            categoryButton.setTextColor(ContextCompat.getColor(requireContext(), android.R.color.white));

            layoutParams.setMargins(25, 25, i == 4 ? 0 : 25, 25);

            categoryButton.setLayoutParams(layoutParams);
            categoryButton.setTag(i);
            categoryButton.setBackground(buttonShape);

            itemCategoryView.addView(categoryButton);
        }
    }
}

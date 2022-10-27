package com.example.moducafe.Fragments;

import static com.google.android.material.tabs.TabLayout.*;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;

import com.example.moducafe.Activity.MainActivity;
import com.example.moducafe.Activity.ShoppingCartActivity;
import com.example.moducafe.Adapter.CategoryDto;
import com.example.moducafe.R;
import com.example.moducafe.Retrofit.RetrofitClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentHome extends Fragment {

    private TabLayout categoryTabLayout;
    private ViewPager2 viewPager2;
    private ViewPagerAdapter viewPagerAdapter;
    private FloatingActionButton floatingActionButton;
    private TabLayoutMediator tabLayoutMediator;
    private static List<CategoryDto> categoryList = new ArrayList<>();

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
        categoryTabLayout = view.findViewById(R.id.categoryTabs);
        viewPager2 = view.findViewById(R.id.view_pager);

        categoryTabLayout.addTab(categoryTabLayout.newTab().setText("COFFE"));
        categoryTabLayout.addTab(categoryTabLayout.newTab().setText("LATTE"));
        categoryTabLayout.addTab(categoryTabLayout.newTab().setText("BEVERAGE"));

        floatingActionButton = view.findViewById(R.id.shopping_card_floating_button);
    }

    private void getData() {
        getAllItems();
    }

    private void setData() {

    }

    private void setButtonClickEvent() {
        viewPager2.registerOnPageChangeCallback(new OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }
        });

        categoryTabLayout.addOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(Tab tab) {

            }

            @Override
            public void onTabReselected(Tab tab) {

            }
        });

        floatingActionButton.setOnClickListener(v -> {
            // go to shopping cart intent

            Intent intent = new Intent(requireActivity().getApplicationContext(), ShoppingCartActivity.class);
            startActivity(intent);
        });
    }

    public static class ViewPagerAdapter extends FragmentStateAdapter {
        public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                case 1:
                case 2:
                case 3:
                    fragment = new FragmentItem(categoryList.get(position).getName());
                    break;
            }

            assert fragment != null;
            return fragment;
        }

        @Override
        public int getItemCount() {
            return 4;
        }
    }

    // Retrofit function
    public void getAllItems() {
        Call<List<CategoryDto>> call = RetrofitClient.getItemApiService().RequestAllItems();

        call.enqueue(new Callback<List<CategoryDto>>() {
            @Override
            public void onResponse(@NonNull Call<List<CategoryDto>> call, @NonNull Response<List<CategoryDto>> response) {
                if(!response.isSuccessful()){
                    Log.e("연결이 비정상적 : ", "error code : " + response.code());
                    return;
                }

                assert response.body() != null;
                List<CategoryDto> categoryDtoList = response.body();

                if(categoryDtoList.size()>0) {
                    categoryList = categoryDtoList;

                    categoryList.stream()
                            .filter(Objects::nonNull)
                            .forEach(categoryDto -> categoryTabLayout.addTab(categoryTabLayout.newTab().setText(categoryDto.getName())));

                    viewPagerAdapter = new ViewPagerAdapter(requireActivity());
                    viewPager2.setAdapter(viewPagerAdapter);

                    tabLayoutMediator = new TabLayoutMediator(categoryTabLayout, viewPager2, (tab, position) -> tab.setText(categoryList.get(position).getName()));
                    tabLayoutMediator.attach();
                }

                Log.d("채팅방 나가기 요청 : ", response.body().toString());
            }

            @Override
            public void onFailure(@NonNull Call<List<CategoryDto>> call, @NonNull Throwable t) {
                Log.e("채팅방 나가기 요청 실패", t.getMessage());
            }
        });
    }
}

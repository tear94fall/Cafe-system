package com.example.moducafe.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.moducafe.Fragments.FragmentHome;
import com.example.moducafe.Fragments.FragmentMember;
import com.example.moducafe.Fragments.FragmentOrder;
import com.example.moducafe.Fragments.FragmentSetting;
import com.example.moducafe.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        setTitle(getString(R.string.app_name_kor));

        bottomNavigationView = findViewById(R.id.navigationView);
        viewPager2 = findViewById(R.id.view_pager);
        viewPager2.setAdapter(new ViewPagerAdapter(this));
    }

    private void setButtonClickEvent() {
        bottomNavigationView.setOnItemSelectedListener(new ItemSelectedListener());

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        setTitle(getString(R.string.home));
                        bottomNavigationView.getMenu().findItem(R.id.homeItem).setChecked(true);
                        break;
                    case 1:
                        setTitle(getString(R.string.membership));
                        bottomNavigationView.getMenu().findItem(R.id.membershipItem).setChecked(true);
                        break;
                    case 2:
                        setTitle(getString(R.string.order));
                        bottomNavigationView.getMenu().findItem(R.id.orderItem).setChecked(true);
                        break;
                    case 3:
                        setTitle(getString(R.string.setting));
                        bottomNavigationView.getMenu().findItem(R.id.settingItem).setChecked(true);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    class ItemSelectedListener implements NavigationBarView.OnItemSelectedListener {
        @SuppressLint("NonConstantResourceId")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.homeItem:
                    setTitle(getString(R.string.home));
                    viewPager2.setCurrentItem(0);
                    break;
                case R.id.membershipItem:
                    setTitle(getString(R.string.membership));
                    viewPager2.setCurrentItem(1);
                    break;
                case R.id.orderItem:
                    setTitle(getString(R.string.order));
                    viewPager2.setCurrentItem(2);
                    break;
                case R.id.settingItem:
                    setTitle(getString(R.string.setting));
                    viewPager2.setCurrentItem(3);
                    break;
            }
            return true;
        }
    }

    static class ViewPagerAdapter extends FragmentStateAdapter {
        public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new FragmentHome();
                    break;
                case 1:
                    fragment = new FragmentMember();
                    break;
                case 2:
                    fragment = new FragmentOrder();
                    break;
                case 3:
                    fragment = new FragmentSetting();
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
}
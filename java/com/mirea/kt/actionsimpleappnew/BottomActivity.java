package com.mirea.kt.actionsimpleappnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class BottomActivity extends AppCompatActivity {
    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Example bottomNavigationView");
        }
        replaceFragment(new HomeFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_home) {
                replaceFragment(new HomeFragment());
                return true;
            } else if (itemId == R.id.navigation_dashboard) {
                replaceFragment(new DashboardFragment());
                return true;
            } else if (itemId == R.id.navigation_notifications) {
                replaceFragment(new NotificationFragment());
                return true;
            }
            return false;
        });
    }
}


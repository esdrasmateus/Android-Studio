package com.example.bottomnavdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.os.Bundle;
import android.view.MenuItem;

import Fragment.Dashboard_Fragment;
import Fragment.Profile_Fragment;
import Fragment.Users_Fragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener
{
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = findViewById(R.id.bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        loadFragment(new Dashboard_Fragment());
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        Fragment fragment = null;
        switch (item.getItemId())
        {
            case R.id.dashboard:
                fragment = new Dashboard_Fragment();
                break;
            case R.id.users:
                fragment = new Users_Fragment();
                break;
            case R.id.profile:
                fragment = new Profile_Fragment();
                break;
        }
        if (fragment != null)
        {
            loadFragment(fragment);
        }
        return true;
    }

    void loadFragment(Fragment fragment)
    {
        // To Attach Fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.relativelayout, fragment).commit();
    }
}
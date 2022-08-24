package com.example.cw9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity  extends AppCompatActivity {
    BottomNavigationView nav ;
    // ActivityMainBinding binding ;
     boolean isswitchOn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final LottieAnimationView Switch= findViewById(R.id.animation);
        Switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isswitchOn){
                    Switch.setMinAndMaxProgress(0.5F,1.0F);
                    Switch.playAnimation();
                    isswitchOn = false ;
                } else {
                    Switch.setMinAndMaxProgress(0.0f,0.5f);
                    Switch.playAnimation();
                    isswitchOn= true ;
                }
            }
        });


        //>>>>>>>>>>>>>>bottombar>>>>>>>>>>>>>>>>
        nav = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_cont ,new HomeFragment());
         nav.setSelectedItemId(R.id.home);
            nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = null ;

                    switch (item.getItemId()) {

                        case R.id.home:
                            Toast.makeText(MainActivity.this, "HOME", Toast.LENGTH_SHORT).show();
                        fragment =  new HomeFragment();
                            break;
                        case R.id.person:
                             new PersonFragment();
                            break;
                        case R.id.settings:
                            Toast.makeText(MainActivity.this, "settings", Toast.LENGTH_SHORT).show();
                             new SettingsFragment();
                            break;
                    }

                    return true;
                }
            });










     /*   binding.bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
                switch (item.getItemId()) {

                    case R.id.home:
                        Toast.makeText(MainActivity.this, "HOME", Toast.LENGTH_SHORT).show();
                        replaceFragment(new HomeFragment());
                        break;
                    case R.id.person:
                        replaceFragment(new PersonFragment());
                        break;
                    case R.id.settings:
                        Toast.makeText(MainActivity.this, "settings", Toast.LENGTH_SHORT).show();
                        replaceFragment(new SettingsFragment());
                        break;
                    default:
                }
                return true;

        });       */
    }

    private void replaceFragment(PersonFragment personFragment) {
    }

    private void replaceFragment(PersonFragment personFragment , SettingsFragment settingsFragment) {
    }

    private void replaceFragment (HomeFragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment );
        fragmentTransaction.commit();
    }
}
package com.cindodcindy.nitippembeli.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.cindodcindy.nitippembeli.R;
import com.cindodcindy.nitippembeli.view.frgament.BookingFragment;
import com.cindodcindy.nitippembeli.view.frgament.CariJasaFragment;
import com.cindodcindy.nitippembeli.view.frgament.ConfirmFragment;
import com.cindodcindy.nitippembeli.view.frgament.DoneFragment;
import com.cindodcindy.nitippembeli.view.frgament.PaymentFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

        //Menampilkan halaman Fragment yang pertama kali muncul
        getFragmentPage(new CariJasaFragment());

        /*Inisialisasi BottomNavigationView beserta listenernya untuk
         *menangkap setiap kejadian saat salah satu menu item diklik
         */
        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigationView);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;

                //Menantukan halaman Fragment yang akan tampil
                switch (item.getItemId()){
                    case R.id.search_lugg_av:
                        fragment = new CariJasaFragment();
                        break;

                    case R.id.booking_lugg:
                        fragment = new BookingFragment();
                        break;

                    case R.id.conf_lugg:
                        fragment = new ConfirmFragment();
                        break;

                    case R.id.payment:
                        fragment = new PaymentFragment();
                        break;

                    case R.id.done:
                        fragment = new DoneFragment();
                        break;
                }
                return getFragmentPage(fragment);
            }
        });
    }

    //Menampilkan halaman Fragment
    private boolean getFragmentPage(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.page_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
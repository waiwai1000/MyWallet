package com.example.asus.mywallet;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;


public class today_wallet extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, walletFragment.OnGetFromUserClickListener {
    private DrawerLayout drawer;

    myDbAdapter helper;
    Fragment walletFragment;
    // EditText daily_limit_wallet, today_usage_wallet, new_amount_wallet, new_desc_wallet;
    // Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_wallet);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new walletFragment()).commit();

        helper = new myDbAdapter(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.update_wallet:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new walletFragment()).commit();
                break;
            case R.id.wallet_history:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new walletHistoryFragment()).commit();
                break;
            case R.id.wallet_stat:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new walletStatFragment()).commit();
                break;
            case R.id.wallet_setting:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new walletSettingFragment()).commit();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

        }

    }

    public void add_new_list(double am, String desc, double limit, double t_usage) {

        long id = helper.insertNewUsage(am, desc, limit, t_usage);


        if (t_usage == 0) {
            long id2 = helper.insertStat(am, limit, t_usage);
        } else {
            int a = helper.update_stat(am, limit, t_usage);

        }
        if (id > 0) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new walletFragment()).commit();

        } else {

            Log.e("Error", "fail to insert");
        }
    }

    /*
    public void update_limit(double new_daily_limit, double new_monthly_limit) {



            int a = helper.update_limit(new_daily_limit,new_monthly_limit);


        if (a>0)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new walletSettingFragment()).commit();

        }
        else
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new walletFragment()).commit();
        }
    }
*/


}

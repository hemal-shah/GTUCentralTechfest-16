package com.example.hemal.gtucentraltechfest16;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    DrawerLayout drawer;
    Toolbar toolbar;
    boolean backKeyPressed = false;
    ActionBar actionBar;
    Resources resources;
    private final static int fragment_id = R.id.frame_layout_activity_main;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setUpActivity();
        resources = getResources();
        openFragment(new HomeFragment());
    }

    private void setUpActivity() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_activity_main);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00933b")));
        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if(backKeyPressed){
                super.onBackPressed();
            }else{
                backKeyPressed = true;
                Snackbar.make(drawer, "Press back again to exit!", Snackbar.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        backKeyPressed = false;
                    }
                }, 1000);
            }
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.app_home:
                openFragment(new HomeFragment());
                setActionBarColor("00933b", "TechFest '16");
                break;
            case R.id.events_menu:
                openFragment(new EventsFragment());
                setActionBarColor("f90101", "Events");
                break;
            case R.id.registration:
                openFragment(new RegistrationFrag());
                setActionBarColor("0266c8", "Registration");
                break;
            case R.id.contact_us_item:
                openFragment(new ContactUsFrag());
                setActionBarColor("f2b505", "Contact Us");
                break;
            case R.id.developers:
                openFragment(new DevelopersFrag());
                setActionBarColor("009688", "Developers");
                break;

            case R.id.map:
                //(23.105081, 72.596947)
                openMap(23.105081, 72.596947);
                break;
            case R.id.nav_share:
                shareMyApp();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void setActionBarColor(String actionBarColor, String title) {
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#" + actionBarColor)));
            actionBar.setTitle(title);
        }
    }

    private void openMap(double latitude, double longitude) {
        String label = "GTU/VGEC";
        String uriBegin = "geo:" + latitude + "," + longitude;
        String query = latitude + "," + longitude + "(" + label + ")";
        String encodedQuery = Uri.encode(query);
        String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
        Uri uri = Uri.parse(uriString);
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void shareMyApp() {
        drawer.closeDrawer(GravityCompat.START);
        Snackbar.make(drawer, "App for share", Snackbar.LENGTH_SHORT).show();
    }

    public void openFragment(final Fragment frag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(fragment_id, frag);
        transaction.commit();
    }
}
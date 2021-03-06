package com.liamgoodwin.eddiebullcupcakes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

/**
 * @author Dessert Due
 * @version 1.0
 * @date December 7th, 2016
 */
public class MainActivity extends AppCompatActivity

        implements OnNavigationItemSelectedListener,
        MainFragment.OnFragmentInteractionListener,
        BakingTipsFragment.OnFragmentInteractionListener,
        BakingTipsDisplayFragment.OnFragmentInteractionListener,
        TripleChocoRecipeFragment.OnFragmentInteractionListener,
        RecipeStepsFragment.OnFragmentInteractionListener,
        AboutUsFragment.OnFragmentInteractionListener,
        FAQFragment.OnFragmentInteractionListener, 
        CupcakesFragment.OnFragmentInteractionListener,
        IngredientsCalculatorFragment.OnFragmentInteractionListener,
        CupcakeCalculatorFragment.OnFragmentInteractionListener,
        MeetTheBakersFragment.OnFragmentInteractionListener,
        ContactUsFragment.OnFragmentInteractionListener {

        FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FragmentTransaction trans = fm.beginTransaction();
        trans.replace(R.id.mainFrame, new MainFragment());
        trans.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

//        if (id == R.id.action_settings) {
//            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
//            startActivity(intent);
//            return true;
//        }

          return super.onOptionsItemSelected(item);
    }

    /**
     * @param item is the item selected from the navigation drawer
     */
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_tips) {
            FragmentTransaction tran = fm.beginTransaction();
            //tran.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
            tran.replace(R.id.mainFrame, new BakingTipsFragment());
            tran.commit();
        }
        else if (id == R.id.nav_recipe) {
            FragmentTransaction tran = fm.beginTransaction();
            tran.replace(R.id.mainFrame, new RecipeStepsFragment());
            tran.commit();
        }
        else if (id == R.id.nav_about) {
            FragmentTransaction tran = fm.beginTransaction();
            tran.replace(R.id.mainFrame, new AboutUsFragment());
            tran.commit();
        }
        else if (id == R.id.nav_cupcakes) {
            FragmentTransaction tran = fm.beginTransaction();
            tran.replace(R.id.mainFrame, new CupcakesFragment());
            tran.commit();
        }
        else if (id == R.id.nav_faq) {
            FragmentTransaction tran = fm.beginTransaction();
            tran.replace(R.id.mainFrame, new FAQFragment());
            tran.commit();
        }
        else if (id == R.id.nav_icalculator) {
            FragmentTransaction tran = fm.beginTransaction();
            tran.replace(R.id.mainFrame, new IngredientsCalculatorFragment());
            tran.commit();
        }
        else if (id == R.id.nav_pcalculator) {
            FragmentTransaction tran = fm.beginTransaction();
            tran.replace(R.id.mainFrame, new CupcakeCalculatorFragment());
            tran.commit();
        }
        else if (id == R.id.nav_bakers) {
            FragmentTransaction tran = fm.beginTransaction();
            tran.replace(R.id.mainFrame, new MeetTheBakersFragment());
            tran.commit();
        }

        else if (id == R.id.nav_contact) {
            FragmentTransaction tran = fm.beginTransaction();
            tran.replace(R.id.mainFrame, new ContactUsFragment());
            tran.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {


    }
}


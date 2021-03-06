package org.techfest.trial;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, CompetitionsFragment.OnFragmentInteractionListener,
        ExhibitionsFragment.OnFragmentInteractionListener,
        IdeateFragment.OnFragmentInteractionListener,
        InitiativesFragment.OnFragmentInteractionListener,
        LecturesFragment.OnFragmentInteractionListener,
        OzoneFragment.OnFragmentInteractionListener,
        SummitFragment.OnFragmentInteractionListener,
        TechnoholixFragment.OnFragmentInteractionListener,
        WorkshopsFragment.OnFragmentInteractionListener
{

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String fragToOpen = intent.getStringExtra("FRAG");
        String pathToFrag = intent.getStringExtra("PATH");

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = null;

        switch (fragToOpen)
        {
            case "CompetitionsFragment":
                fragment = new CompetitionsFragment();
                break;
            case "ExhibitionsFragment":
                fragment = new ExhibitionsFragment();
                break;
            case "IdeateFragment":
                fragment = new IdeateFragment();
                break;
            case "InitiativesFragment":
                fragment = new InitiativesFragment();
                break;
            case "LecturesFragment":
                fragment = new LecturesFragment();
                break;
            case "OzoneFragment":
                fragment = new OzoneFragment();
                break;
            default:
                fragment = new CompetitionsFragment();
        }

        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = new InitiativesFragment();

        if (id == R.id.initiatives_item) {
            fragment = new InitiativesFragment();
        } else if (id == R.id.ideate_item) {
            fragment = new IdeateFragment();

        } else if (id == R.id.competitions_item) {
            fragment = new CompetitionsFragment();

        } else if (id == R.id.workshops_item) {
            fragment = new WorkshopsFragment();

        } else if (id == R.id.lectures_item) {
            fragment = new LecturesFragment();

        } else if (id == R.id.summit_item) {
            fragment = new SummitFragment();

        } else if (id == R.id.exhibitions_item) {
            fragment = new ExhibitionsFragment();

        } else if (id == R.id.technoholix_item) {
            fragment = new TechnoholixFragment();

        } else if (id == R.id.ozone_item) {
            fragment = new OzoneFragment();

        }
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

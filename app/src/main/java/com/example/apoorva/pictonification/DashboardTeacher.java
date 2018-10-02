package com.example.apoorva.pictonification;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DashboardTeacher extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Fragment events = new Events();
    Fragment notices = new Notices();
    Fragment study_material = new StudyMaterial();
    Fragment forum = new Forum();
    Fragment upload = new Upload();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_teacher);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if(firebaseUser != null)
        {
            Toast.makeText(getApplicationContext(),firebaseUser.getEmail(),Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"No User",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            finishAffinity();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
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

        if (id == R.id.nav_events) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_dashboard_frame, events).commit();

        } else if (id == R.id.nav_home) {
            Intent i=new Intent(DashboardTeacher.this, Dashboard.class);
            startActivity(i);

        }else if (id == R.id.nav_notices) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_dashboard_frame, notices).commit();

        } else if (id == R.id.nav_study_material) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_dashboard_frame, study_material).commit();

        } else if (id == R.id.nav_forum) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_dashboard_frame, forum).commit();

        } else if (id == R.id.nav_upload) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_dashboard_frame, upload).commit();

        }

        else if (id == R.id.nav_logout) {
            FirebaseAuth.getInstance().signOut();
            Intent logintent=new Intent(DashboardTeacher.this,LogIn.class);
            finish();
            startActivity(logintent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        /*Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, "Hello World!"));*/

        return true;
    }


}

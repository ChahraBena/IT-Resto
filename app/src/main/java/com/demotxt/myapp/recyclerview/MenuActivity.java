package com.demotxt.myapp.recyclerview;



import android.graphics.drawable.Drawable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private static final String TAG = "MenuActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mDesc = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Log.d(TAG, "onCreate: started.");




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab5);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.menu_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://image.noelshack.com/fichiers/2018/18/3/1525258008-salade.png");
        mNames.add("Entrées");
        mDesc.add("Proinde die funestis , et adsistebant hinc inde notarii");

        mImageUrls.add("https://image.noelshack.com/fichiers/2018/18/3/1525258007-plat.png");
        mNames.add("Plats");
        mDesc.add("Emensis itaque , resistente multitudine Alamanna pontem suspendere navium.");

        mImageUrls.add("https://image.noelshack.com/fichiers/2018/18/3/1525258007-dessert.png");
        mNames.add("Desserts");
        mDesc.add("Sed laeditur, indulta licentia vitiis ad errores lapsorum ac lasciviam.");

        mImageUrls.add("https://image.noelshack.com/fichiers/2018/18/3/1525258007-boisson.png");
        mNames.add("Boissons");
        mDesc.add("Et interdum acciderat, velut Amphiarao referente aut Marcio.");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter2 adapter = new RecyclerViewAdapter2(this, mNames, mImageUrls,mDesc);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.menu_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_drawer__frag_drawer, menu);
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

        if (id == R.id.ReserverItem) {
            // Handle the camera action
        } else if (id == R.id.PanierItem) {

        } else if (id == R.id.MenuItem) {

        } else if (id == R.id.EmailItem) {

        } else if (id == R.id.appelItem) {

        } else if (id == R.id.FavoriteItem) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.menu_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

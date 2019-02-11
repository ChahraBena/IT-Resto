package com.demotxt.myapp.recyclerview;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


import java.util.ArrayList;

import static com.demotxt.myapp.recyclerview.R.id.food_layout;

public class FoodDelivery extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView recyclerView;

    ArrayList<FoodModel> foodsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
/*
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar2));
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, (DrawerLayout)findViewById(food_layout), (Toolbar)findViewById(R.id.toolbar2), R.string.navigation_drawer_open, R.string.navigation_drawer_close);


        findViewById(food_layout).addDrawerListener(new ActionBarDrawerToggle(toggle));
//        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this);
*/



//////



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


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.food_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        //////
        String text = "rien"; text=getIntent().getStringExtra("image_name");
        int[] images=new int[]{};
        if (text.compareTo("Entrées")==0){
            images = new int[]{R.drawable.entree1, R.drawable.entree2, R.drawable.entree3, R.drawable.entree4};
        }else{
            if (text.compareTo("Plats")==0){
                images = new int[]{R.drawable.plat12, R.drawable.plat22, R.drawable.plat32, R.drawable.plat42};
            }else{
                if (text.compareTo("Boissons")==0){
                    images = new int[]{R.drawable.boisson1, R.drawable.boisson2, R.drawable.boisson3, R.drawable.boisson4};

                }else{
                    images = new int[]{R.drawable.dessert1, R.drawable.dessert2, R.drawable.dessert3, R.drawable.dessert4};
                }

            }

        }

        recyclerView = findViewById(R.id.rv);


        String[] names = {"chaat", "haleem", "kare", "seafood"};
        String[] places = {"Karachi savour", "Srena", "Mariot", "Chaman"};
        String[] prices = {"$4", "$5", "$10", "$15"};

        foodsList = new ArrayList<>();


        for (int i = 0; i < names.length; i++) {
            FoodModel item_food=new FoodModel(names[i], places[i], prices[i], images[i]);

            foodsList.add(item_food);

        }
/*

*/
        FoodDeliverAdapter adapter = new FoodDeliverAdapter(this, foodsList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());

        RecyclerView.LayoutManager mLayoutManager = linearLayoutManager;



        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.food_layout);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.food_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}



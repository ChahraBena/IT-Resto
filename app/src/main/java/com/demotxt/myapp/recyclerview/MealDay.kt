package com.demotxt.myapp.recyclerview


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.TextView
import kotlinx.android.synthetic.main.app_bar_meal_day.*

import kotlinx.android.synthetic.main.activity_meal_day.*
import org.jetbrains.anko.email
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.makeCall

open class MealDay : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var idresto=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_day)
        setSupportActionBar(toolbar2)



        fab.setOnClickListener {
            startActivity(intentFor<AddBasket>("idresto" to 5))
        }
        val toggle = ActionBarDrawerToggle(
                this,  meal_layout, toolbar2, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        meal_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        var plat=findViewById<TextView>(R.id.platname) as TextView
        var str= resources.getStringArray(R.array.platname)
        plat.setText(str[0])
        plat=findViewById<TextView>(R.id.detailscont) as TextView
        str=  resources.getStringArray(R.array.plats)
        plat.setText(str[0])
        plat=findViewById<TextView>(R.id.date) as TextView
        str=  resources.getStringArray(R.array.Date)
        plat.setText(str[0])
    }
    override fun onBackPressed() {
        if (meal_layout.isDrawerOpen(GravityCompat.START)) {
            meal_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: android.view.Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.drawer_, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            R.id.action_quitter -> finish()
            else -> return super.onOptionsItemSelected(item)
        }
        return true

    }

    @SuppressLint("MissingPermission")
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.ReserverItem -> {
                startActivity(intentFor<Registration>("idresto" to idresto))
                return true
            }
            R.id.PanierItem -> {
                return true
            }
            R.id.MenuItem -> {
                return true
            }
            R.id.FavoriteItem-> {
                return true
            }
            R.id.EmailItem -> {
                return email("ec_bennani@esi.dz","","")
            }

            R.id.appelItem -> {
                return makeCall("+213559350618")
            }
        }
        return true
        //accueil_layout.closeDrawer(GravityCompat.START)
    }

}




package com.demotxt.myapp.recyclerview

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_localisation.*
import org.jetbrains.anko.email
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.makeCall
import android.view.View
import android.widget.TextView
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
import kotlinx.android.synthetic.main.app_bar_localisation.*


class Localisation : AppCompatActivity(), OnMapReadyCallback, NavigationView.OnNavigationItemSelectedListener {

    val idresto=0
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_localisation)
        setSupportActionBar(toolbar2)
        val toggle = ActionBarDrawerToggle(
                this,  localisation_layout, toolbar2, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        localisation_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }
    override fun onBackPressed() {
        if (localisation_layout.isDrawerOpen(GravityCompat.START)) {
            localisation_layout.closeDrawer(GravityCompat.START)
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

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        // Add a marker in Sydney and move the camera
        mMap.setInfoWindowAdapter(object : InfoWindowAdapter {

            // Use default InfoWindow frame
            override fun getInfoWindow(marker: Marker): View? {
                return null
            }

            // Defines the contents of the InfoWindow
            override fun getInfoContents(marker: Marker): View {

                // Getting view from the layout file info_window_layout
                val v = layoutInflater.inflate(R.layout.info_window, null)
                // Returning the view containing InfoWindow contents
                return v

            }

        })
        val sydney = LatLng(36.72, 3.1948)
        val zoom:Float= 13.0F
        mMap.addMarker(MarkerOptions().position(sydney).title("The Polar ranch").snippet("Restaurant Italien")).showInfoWindow()
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,zoom))
    }

}


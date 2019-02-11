package com.demotxt.myapp.recyclerview


import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.CardView
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_acceuil.*
import kotlinx.android.synthetic.main.app_bar_accueil.*
import org.jetbrains.anko.email
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.makeCall

class Acceuil : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{
    val idresto=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acceuil)
        setSupportActionBar(toolbar2)
        val toggle = ActionBarDrawerToggle(
                this,  accueil_layout, toolbar2, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        accueil_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        val card1= findViewById<CardView>(R.id.card_menu)
        card1.setOnClickListener(clickListener)
        val card2= findViewById<CardView>(R.id.card_plat)
        card2.setOnClickListener(clickListener)
        val card3= findViewById<CardView>(R.id.card_registration)
        card3.setOnClickListener(clickListener)
        val card4= findViewById<CardView>(R.id.card_localisation)
        card4.setOnClickListener(clickListener)
        val card5= findViewById<CardView>(R.id.card_information)
        card5.setOnClickListener(clickListener)
        val card6= findViewById<CardView>(R.id.card_images)
        card6.setOnClickListener(clickListener)
    }

    val clickListener = View.OnClickListener {view ->

        when (view.getId()) {

            //R.id.card_menu-> startActivity(intentFor<Menu>("idresto" to idresto))
            R.id.card_plat-> startActivity(intentFor<MealDay>("idresto" to idresto))
            R.id.card_registration-> startActivity(intentFor<Registration>("idresto" to idresto))
            R.id.card_localisation-> startActivity(intentFor<Localisation>("idresto" to idresto))
            R.id.card_information-> {
                startActivity(intentFor<Resto_Activity>(
                        "Title" to "Francescana",
                        "Description" to "Ut enim benefici liberalesque sumus, non ut exigamus gratiam (neque enim beneficium faeneramur sed natura propensi ad liberalitatem sumus), sic amicitiam non spe mercedis adducti sed quod omnis eius fructus in ipso amore inest, expetendam putamus.",
                        "Thumbnail" to R.drawable.rest_img_1,
                        "Facebook" to "fb.com/Francescana",
                        "Num" to "021459628",
                        "Mail" to "Francescana@gmail.com",
                        "Twitter" to "Twitter/@Francescana",
                        "Adresse" to "Adresse Resto 1"
                )
                )
            }


            R.id.card_menu-> startActivity(intentFor<MenuActivity>("idresto" to idresto))



                    R.id.card_images-> startActivity(intentFor<Photos>("idresto" to idresto))
        }
        //  val card=view as CardView
        /*  if(card.background.equals(-1))
          {
                 card.setCardBackgroundColor(Color.RED)
          }
          else
          {
              card.setCardBackgroundColor(-1)
          }*/

    }
    override fun onBackPressed() {
        if (accueil_layout.isDrawerOpen(GravityCompat.START)) {
            accueil_layout.closeDrawer(GravityCompat.START)
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
            R.id.action_panier->
                startActivity(intentFor<Panier2>("idresto" to idresto))
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
                startActivity(intentFor<Panier2>("idresto" to idresto))
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


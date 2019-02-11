package com.demotxt.myapp.recyclerview

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.annotation.RequiresApi
import android.support.design.widget.NavigationView
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.android.synthetic.main.app_bar_registration.*
import org.jetbrains.anko.email
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.makeCall
import org.jetbrains.anko.toast
import java.time.LocalDateTime
import java.text.SimpleDateFormat
import java.util.*

class Registration : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    val idresto =0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        setSupportActionBar(toolbar2)
        val toggle = ActionBarDrawerToggle(
                this,  registration_layout, toolbar2, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        registration_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
        val textView: TextView  = findViewById(R.id.datetxt)
        textView.text = SimpleDateFormat("dd.MM.yyyy").format(System.currentTimeMillis())
        val time=findViewById<TextView>(R.id.heure)
        var cal = Calendar.getInstance()

        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd.MM.yyyy" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            textView.text = sdf.format(cal.time)

        }

        textView.setOnClickListener {
            DatePickerDialog(this@Registration, dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
        }
        val heuretext=findViewById<TextView>(R.id.heure)
        heuretext.setText("12:00")  //currentDateTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT))
        heuretext.setOnClickListener {
            val timelistener=TimePickerDialog.OnTimeSetListener{
                timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY,hour)
                cal.set(Calendar.MINUTE,minute)
                heuretext.text=SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(this,timelistener,cal.get(Calendar.HOUR_OF_DAY),cal.get(Calendar.MINUTE),true).show()
        }
        /*   val nom=findViewById<EditText>(R.id.Nom)
           val prenom = findViewById<EditText>(R.id.prenom)
           val comm=findViewById<EditText>(R.id.comments)
           var i1=0
           var i2=0
           var i3=0
           nom.setOnClickListener(click)*/
        val annuler= findViewById<Button>(R.id.RollbackButton)
        val confirmButt=findViewById<Button>(R.id.ConfirmButton)
        annuler.setOnClickListener(clickListener)
        confirmButt.setOnClickListener(clickListener)

    }
    /*  val click=View.OnClickListener {view ->
          when (view.getId()) {
             // R.id.Nom-> setText
              R.id.prenom-> toast("Opération confirmée")
              R.id.comments -> toast("Opération confirmée")
          }
      }*/

    val clickListener = View.OnClickListener {view ->

        when (view.getId()) {
            R.id.RollbackButton-> toast("Opération annulée")
            R.id.ConfirmButton-> toast("Opération confirmée")
        }
        finish()
    }
    override fun onBackPressed() {
        if (registration_layout.isDrawerOpen(GravityCompat.START)) {
            registration_layout.closeDrawer(GravityCompat.START)
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

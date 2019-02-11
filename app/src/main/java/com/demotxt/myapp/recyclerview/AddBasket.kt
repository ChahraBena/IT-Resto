package com.demotxt.myapp.recyclerview

import android.app.Activity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import com.michaelmuenzer.android.scrollablennumberpicker.ScrollableNumberPicker
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.toast

/**
 * Created by user on 23/04/2018.
 */
class AddBasket:Activity()  {

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addbasketpop)
        val dm=DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        val width=dm.widthPixels
        val height=dm.heightPixels
        window.setLayout((width*0.85).toInt(),(height*0.5).toInt())
        //val sc=findViewById<NumberPicker>(R.id.p0)
        //sc.value=1
        //val prix=findViewById<TextView>(R.id.prix)
        //  prix.setText("3000"+" DA")
        // old:Int=0
        val new:Int=0

        //    sc.setOnValueChangedListener (this,old,new){ toast("ok")}
        //  sc.setOnClickListener { prix.setText("ok") }
        val add=findViewById<Button>(R.id.Badd)
        val valid=findViewById<Button>(R.id.Bval)
        val snak:Snackbar
        add.setOnClickListener({
            snackbar(add,"ajouté au panier","annuler"){
                toast("oparation annulée")
            }
        })

    }

}
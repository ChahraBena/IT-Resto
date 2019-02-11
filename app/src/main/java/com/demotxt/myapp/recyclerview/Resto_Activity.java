package com.demotxt.myapp.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Resto_Activity extends AppCompatActivity {

    private TextView tvtitle,tvdescription,tvcategory,tvfacebook,tvmail,tvnum,tvtwitter,tvadresse;
    private ImageView img;
    public Button but1;

    public void init(){

        but1=(Button)findViewById(R.id.but1);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy = new Intent(Resto_Activity.this,Acceuil.class);
                startActivity(toy);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resto_);
        init();

        tvtitle = (TextView) findViewById(R.id.txttitle);
        tvdescription = (TextView) findViewById(R.id.txtDesc);
        //tvcategory = (TextView) findViewById(R.id.txtCat);
        img = (ImageView) findViewById(R.id.bookthumbnail);

        tvfacebook=(TextView) findViewById(R.id.txtfacebook);
        tvnum=(TextView) findViewById(R.id.txtnum);
        tvmail=(TextView) findViewById(R.id.txtmail);
        tvtwitter=(TextView) findViewById(R.id.txttwitter);
        tvadresse=(TextView) findViewById(R.id.txtadresse);




        // Recieve data
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Description = intent.getExtras().getString("Description");
        String Facebok=intent.getExtras().getString("Facebook");
        String Mail=intent.getExtras().getString("Mail");
        String Num=intent.getExtras().getString("Num");
        String Twitter=intent.getExtras().getString("Twitter");
        String Adresse=intent.getExtras().getString("Adresse");





        int image = intent.getExtras().getInt("Thumbnail") ;

        // Setting values

        tvtitle.setText(Title);
        tvdescription.setText(Description);
        img.setImageResource(image);

        tvfacebook.setText(Facebok);
        tvmail.setText(Mail);
        tvnum.setText(Num);
        tvtwitter.setText(Twitter);
        tvadresse.setText(Adresse);
    }
}

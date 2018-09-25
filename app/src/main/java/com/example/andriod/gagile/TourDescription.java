package com.example.andriod.gagile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class TourDescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_tour_description );


        String loadsPosition = getIntent().getStringExtra( "loadsPosition" );
        String loadsPosition2 = getIntent().getStringExtra( "loadsPosition2" );
        String loadsPosition4 = getIntent().getStringExtra( "loadsPosition4" );
        Bundle bundle = this.getIntent().getExtras();
        int pic = bundle.getInt( "loadsPosition3" );
        TextView textView1 = findViewById( R.id.card_img_tdescr );
        TextView textView2 = findViewById( R.id.card_img_mdescr );
        TextView textView = findViewById( R.id.card_img_descr );
        textView.setText( loadsPosition );
        textView2.setText( loadsPosition4 );
        textView1.setText( loadsPosition2 );
        ImageView imageView = findViewById( R.id.card_img );
        imageView.setImageResource( pic );
    }
}

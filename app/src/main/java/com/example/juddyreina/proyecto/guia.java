package com.example.juddyreina.proyecto;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class guia extends AppCompatActivity implements Animation.AnimationListener {

    private TextView tvTitle;
    private TextView tvInfo;
    private ImageButton btnOut;
    private ImageView img;
    Animation animZoomI;
    Animation animZoomO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guia);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/TimKid.ttf");

        tvTitle=(TextView) findViewById(R.id.titleG);
        tvInfo=(TextView) findViewById(R.id.idinfo);
        img=(ImageView) findViewById(R.id.idImagen);
        btnOut=(ImageButton) findViewById(R.id.btnExit);
        tvTitle.setTypeface(myCustomFont);
        tvInfo.setTypeface(myCustomFont);

        animZoomI = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        animZoomI.setAnimationListener(this);
        animZoomO = AnimationUtils.loadAnimation(this, R.anim.zoom_out);
        animZoomO.setAnimationListener(this);

        img.setImageResource(R.drawable.nina);

        tvInfo.setText(R.string.help);
        btnOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.clearAnimation();
                Intent i = new Intent(guia.this, Mostrar.class);
                startActivity(i);
            }
        });


    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        // Animation is repeating
    }

    @Override
    public void onAnimationStart(Animation animation) {
        // Animation started

    }


}

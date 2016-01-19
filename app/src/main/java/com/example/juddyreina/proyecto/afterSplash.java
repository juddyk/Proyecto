package com.example.juddyreina.proyecto;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class afterSplash extends AppCompatActivity implements Animation.AnimationListener {
    private Button btn;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private TextView tv;
    private ImageView iv;
    Animation animFadein;
    Animation animFadeout;
    Animation animBounce;
    Animation animSlideup;
    Animation animSlidedown;
    Animation animRotZoom;
    Animation animMov;
    Animation animRotate;
    private SharedPreferences.Editor preferenceEditor;
    private static final int PREFERENCE_MODE_PRIVATE=0;
    private SharedPreferences preferenceSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_splash);

        btn=(Button) findViewById(R.id.idBtnS);
        btn1=(Button) findViewById(R.id.Btn1);
        btn2=(Button) findViewById(R.id.Btn2);
        btn3=(Button) findViewById(R.id.Btn3);
        tv=(TextView) findViewById(R.id.tv1);
        iv=(ImageView) findViewById(R.id.idImg);

        animFadein = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        animFadein.setAnimationListener(this);
        animFadeout = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        animFadeout.setAnimationListener(this);
        animBounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
        animBounce.setAnimationListener(this);
        animSlideup = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        animSlideup.setAnimationListener(this);
        animSlidedown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        animSlidedown.setAnimationListener(this);
        animRotZoom = AnimationUtils.loadAnimation(this, R.anim.rot_zoom);
        animRotZoom.setAnimationListener(this);
        animMov = AnimationUtils.loadAnimation(this, R.anim.mov);
        animMov.setAnimationListener(this);
        animRotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        animRotate.setAnimationListener(this);

        //se define el tipo de fuente, se usa una externa
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/TimKid.ttf");
        //tipo de fuente
        btn.setTypeface(myCustomFont);
        btn1.setTypeface(myCustomFont);
        btn2.setTypeface(myCustomFont);
        btn3.setTypeface(myCustomFont);
        tv.setTypeface(myCustomFont);

        preferenceSettings = getPreferences(PREFERENCE_MODE_PRIVATE);
        preferenceEditor=preferenceSettings.edit();

        preferenceEditor.putBoolean("skip",true);
        preferenceEditor.commit();
        btn.setVisibility(View.INVISIBLE);
        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);

        btn1.startAnimation(animRotate);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(afterSplash.this, MainActivity.class);
                startActivity(i);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setImageResource(R.drawable.ic_apprende);
                iv.setAnimation(animSlidedown);
                tv.setText(R.string.texto1);
                tv.startAnimation(animFadein);
                btn1.startAnimation(animFadeout);
                btn1.setVisibility(View.GONE);
                btn2.startAnimation(animFadein);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setImageResource(R.drawable.palabras);
                tv.setText(R.string.texto2);
                tv.startAnimation(animMov);
                iv.setAnimation(animBounce);
                btn2.startAnimation(animFadeout);
                btn2.setVisibility(View.GONE);
                btn3.startAnimation(animFadein);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setImageResource(R.drawable.plan);
                tv.setText(R.string.texto3);
                tv.startAnimation(animBounce);
                iv.setAnimation(animRotZoom);
                btn3.startAnimation(animFadeout);
                btn3.setVisibility(View.GONE);
                btn.startAnimation(animFadein);
                btn.setVisibility(View.VISIBLE);
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

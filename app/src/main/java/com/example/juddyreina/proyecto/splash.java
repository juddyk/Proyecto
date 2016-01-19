package com.example.juddyreina.proyecto;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class splash extends AppCompatActivity {
    private static final long SPLASH_DELAY=5000;
    AnimatorSet star1Set;
    AnimatorSet star2Set;
    AnimatorSet star3Set;
    AnimatorSet star4Set;

    private SharedPreferences.Editor preferenceEditor;
    private static final int PREFERENCE_MODE_PRIVATE=0;
    private SharedPreferences preferenceSettings;
    boolean flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        preferenceSettings = getPreferences(PREFERENCE_MODE_PRIVATE);
        preferenceEditor=preferenceSettings.edit();

        ImageView ap = (ImageView)findViewById(R.id.ap);
        ImageView pr = (ImageView)findViewById(R.id.pr);
        ImageView en = (ImageView)findViewById(R.id.en);
        ImageView de = (ImageView)findViewById(R.id.de);

        star1Set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.ap);
        star1Set.setTarget(ap);

        star2Set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.pr);
        star2Set.setTarget(pr);

        star3Set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.en);
        star3Set.setTarget(en);

        star4Set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.de);
        star4Set.setTarget(de);

        star1Set.start();
        star2Set.start();
        star3Set.start();
        star4Set.start();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                star1Set.end();
                star2Set.end();
                star3Set.end();
                star4Set.end();
                if(preferenceSettings.getBoolean("flag",flag)){
                    Intent i = new Intent(splash.this, addChild.class);
                    startActivity(i);

                }else{
                    Intent i = new Intent(splash.this, afterSplash.class);
                    startActivity(i);
                }

            }
        };
        Timer timer=new Timer();
        timer.schedule(task, SPLASH_DELAY);

    }
}

package com.lz69.stackoverflow;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.LinearInterpolator;

import com.lz69.stackoverflow.view.TextView_1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView_1 tvTip = (TextView_1) findViewById(R.id.tvTip);
        final ObjectAnimator anim4 = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.rotate_four);
        anim4.setTarget(tvTip);
        anim4.setInterpolator(new LinearInterpolator());
        anim4.addListener(new AnimatorListenerAdapter(){
            @Override
            public void onAnimationEnd(Animator animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        anim4.start();
                    }
                }, 3000);
            }
        });
        anim4.start();
        Log.i("zoulilang", "onCreate()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("zoulilang", "onResume()");
    }
}

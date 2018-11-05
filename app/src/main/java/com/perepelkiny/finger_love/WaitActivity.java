package com.perepelkiny.finger_love;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;

public class WaitActivity extends AppCompatActivity {

    TextView percentsView;
    ProgressBar progressBar;
    Animation animation;
    Animation.AnimationListener animationListener;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait);

        percentsView = (TextView) findViewById(R.id.percents_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        intent = new Intent(this, Result_Activity.class);

        animationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(intent);
                WaitActivity.this.finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };

        animation = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                super.applyTransformation(interpolatedTime, t);
                float value = 100 * interpolatedTime;
                progressBar.setProgress((int) value);
                percentsView.setText(String.valueOf(Math.round(value)) + " %");
            }
        };

        animation.setAnimationListener(animationListener);
        animation.setDuration(3000);
        progressBar.startAnimation(animation);
    }
}
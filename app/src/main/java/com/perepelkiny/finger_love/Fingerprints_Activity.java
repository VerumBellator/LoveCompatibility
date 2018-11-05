package com.perepelkiny.finger_love;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import java.util.Timer;
import java.util.TimerTask;

public class Fingerprints_Activity extends AppCompatActivity implements View.OnTouchListener {

    private class Task extends TimerTask {
        @Override
        public void run() {
            startActivity(intent);
            touchTimer.purge();
            Fingerprints_Activity.this.finish();
        }
    }

    private ImageButton fingerprintUp, fingerprintDown;
    private boolean fingerprintUpTouched = false;
    private boolean fingerprintDownTouched = false;
    private Timer touchTimer;
    private Task timerTask;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fingerprints);
        fingerprintUp = (ImageButton) findViewById(R.id.fingerprint_button_Up);
        fingerprintDown = (ImageButton) findViewById(R.id.fingerprint_button_Down);
        fingerprintUp.setOnTouchListener(this);
        fingerprintDown.setOnTouchListener(this);
        touchTimer = new Timer();
        intent = new Intent(this, WaitActivity.class);
        timerTask = new Task();
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch (view.getId()) {
            case R.id.fingerprint_button_Up:
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (fingerprintDownTouched) {
                            fingerprintUpTouched = true;
                            timerTask = new Task();
                            touchTimer.schedule(timerTask, 3000);
                        } else {
                            fingerprintUpTouched = true;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        fingerprintUpTouched = false;
                        touchTimer.purge();
                        timerTask.cancel();
                        break;
                }
                break;
            case R.id.fingerprint_button_Down:
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (fingerprintUpTouched) {
                            fingerprintDownTouched = true;
                            timerTask = new Task();
                            touchTimer.schedule(timerTask, 3000);
                        } else {
                            fingerprintDownTouched = true;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        fingerprintDownTouched = false;
                        touchTimer.purge();
                        timerTask.cancel();
                        break;
                }
                break;
        }
        return false;
    }
}

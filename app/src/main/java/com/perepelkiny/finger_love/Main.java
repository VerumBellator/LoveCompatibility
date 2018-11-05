package com.perepelkiny.finger_love;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity implements View.OnClickListener {

    Button startButton, infoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        startButton = (Button) findViewById(R.id.start_button);
        infoButton = (Button) findViewById(R.id.info_button);
        startButton.setOnClickListener(this);
        infoButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_button:
                Intent intent = new Intent(this, Fingerprints_Activity.class);
                startActivity(intent);
                break;
            case R.id.info_button:
                InfoDialogFragment dialog = new InfoDialogFragment();
                dialog.show(getSupportFragmentManager(), "info");
                break;
        }
    }
}

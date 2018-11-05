package com.perepelkiny.finger_love;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class Result_Activity extends AppCompatActivity {

    TextView percentView, resultInfoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_);
        percentView = (TextView) findViewById(R.id.resultPercentView);
        resultInfoView = (TextView) findViewById(R.id.resultDescriptionView);
        int result = getRandomInt(60, 100);
        percentView.setText(String.valueOf(result));
        setResultDescription(result);
    }

    private int getRandomInt (int min, int max) {
        Random rnd = new Random();
        int number = min + rnd.nextInt(max - min + 1);
        return number;
    }

    private void setResultDescription (int result) {
        if (result >= 60 && result < 70) {
            resultInfoView.setText("Vse ploho");
            return;
        }
        else if (result >= 70 && result < 80) {
            resultInfoView.setText("Norm");
            return;
        }
        else if (result >= 80 && result < 90) {
            resultInfoView.setText("Horosho");
            return;
        }
        resultInfoView.setText("Otlichno");
    }
}

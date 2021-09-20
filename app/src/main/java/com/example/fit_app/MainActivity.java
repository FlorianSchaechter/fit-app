package com.example.fit_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    CountDownTimer timer;
    EditText numberField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberField = (EditText) findViewById(R.id.secondsCounter);


        timer = new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                numberField.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                numberField.setText("done!");
            }
        };
    }

    public void startTimer(View view) {
        timer.start();
    }
}
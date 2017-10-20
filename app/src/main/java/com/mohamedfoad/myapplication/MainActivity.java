package com.mohamedfoad.myapplication;

import android.os.CountDownTimer;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mTextField;
    EditText userTime;
    long test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextField = (TextView) findViewById(R.id.textCountdown);
        userTime = (EditText) findViewById(R.id.enterTime);
        String time = userTime.getText().toString();
        if (!time.equals("")) {
            test = Long.parseLong(time);
        }
    }

    public void startCountdown(View view) {

        userTime = (EditText) findViewById(R.id.enterTime);
        String time = userTime.getText().toString();
        if (!time.equals("")) {
            test = Long.parseLong(time);
        }

        new CountDownTimer(test, 1000) {

            public void onTick(long millisUntilFinished) {
                mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                mTextField.setText("done!");
            }
        }.start();

    }
}

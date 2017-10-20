package com.mohamedfoad.myapplication;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.DonutProgress;

public class pomodoroActivity extends AppCompatActivity {
    TextView mTextField;
    EditText userTime;
    long test;
    DonutProgress progress;
int time = 25000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pomodoro);

        progress = (DonutProgress) findViewById(R.id.donut_progress);

       progress.setMax(25);
    }

    public void startCountdownPomodoro(View view) {

        new CountDownTimer(1500000, 1000) {

            public void onTick(long millisUntilFinished) {
               // mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
                progress.setProgress(millisUntilFinished / 1000/60);

            }

            public void onFinish() {
                mTextField.setText("done!");
            }
        }.start();

    }
}

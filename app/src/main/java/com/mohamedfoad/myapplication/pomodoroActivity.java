package com.mohamedfoad.myapplication;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.DonutProgress;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

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
        mTextField = (TextView) findViewById(R.id.textCountdown);
        progress = (DonutProgress) findViewById(R.id.donut_progress);

        progress.setMax(25);
    }

    public void startCountdownPomodoro(View view) {

        new CountDownTimer(1500000, 1000) {

            public void onTick(long millisUntilFinished) {

                progress.setProgress(millisUntilFinished / 1000 / 60);

                String text = String.format(Locale.getDefault(), "%02d:%02d",
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % 60,
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60);
                mTextField.setText(text);

            }

            public void onFinish() {
                mTextField.setText("done!");
            }
        }.start();

    }
}

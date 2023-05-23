package com.example.countdowntimer_voi_progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Button btnDownload, btnDownloadLienTuc, btnResetDownload;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int progress = progressBar.getProgress();
                progressBar.setProgress(progress + 20);
                progressBar.setSecondaryProgress(progress + 40);
            }
        });

        btnResetDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setProgress(0);
                progressBar.setSecondaryProgress(0);
            }
        });

        btnDownloadLienTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownTimer countDownTimer = new CountDownTimer(5000, 500) {
//                  5 000 là lặp trong 5s
//                  500 là cách 0.5s lặp 1 lần
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int progress = progressBar.getProgress();
                        if(progress >= progressBar.getMax()){
                            progressBar.setProgress(0);
                            progressBar.setSecondaryProgress(0);
                            progress = progressBar.getProgress();
                        }
                        progressBar.setProgress(progress + 20);
                        progressBar.setSecondaryProgress(progress + 40);
                    }

                    @Override
                    public void onFinish() {
                        Toast.makeText(MainActivity.this, "Download thành công lần thứ " + ++count, Toast.LENGTH_SHORT).show();
                        this.start();
                    }
                };
                countDownTimer.start();
            }
        });
    }

    private void anhXa() {
        progressBar = findViewById(R.id.progressBar);
        btnDownload = findViewById(R.id.buttonDownload);
        btnDownloadLienTuc = findViewById(R.id.buttonDownloadLienTuc);
        btnResetDownload = findViewById(R.id.buttonResetDownload);
    }
}
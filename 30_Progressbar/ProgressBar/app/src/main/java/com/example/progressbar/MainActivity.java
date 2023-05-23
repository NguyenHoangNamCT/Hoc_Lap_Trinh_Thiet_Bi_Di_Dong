package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Button btnDownload, btnResetDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int progress = progressBar.getProgress();
                progressBar.setProgress(progress + 10);
                progressBar.setSecondaryProgress(progress + 20);
            }
        });

        btnResetDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setProgress(0);
                progressBar.setSecondaryProgress(0);
            }
        });
    }

    public void anhXa(){
        progressBar = findViewById(R.id.progressBar);
        btnDownload = findViewById(R.id.button);
        btnResetDownload = findViewById(R.id.button2);
    }
}
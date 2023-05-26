package com.example.cuocduakythu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar1, seekBar2, seekBar3, seekBar4;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    TextView textViewDiem;
    ImageButton imageButtonPlay;
    Random r;
    int min, max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        anhXa();

        r = new Random();
        min = 1;
        max = 4;

        imageButtonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seekBar1.setProgress(0);
                seekBar2.setProgress(0);
                seekBar3.setProgress(0);
                seekBar4.setProgress(0);
                CountDownTimer countDownTimer = new CountDownTimer(10000, 300) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int r1 = r.nextInt(max - min + 1) + min;
                        int r2 = r.nextInt(max - min + 1) + min;
                        int r3 = r.nextInt(max - min + 1) + min;
                        int r4 = r.nextInt(max - min + 1) + min;

                        seekBar1.setProgress(seekBar1.getProgress() + r1);
                        seekBar2.setProgress(seekBar2.getProgress() + r2);
                        seekBar3.setProgress(seekBar3.getProgress() + r3);
                        seekBar4.setProgress(seekBar4.getProgress() + r4);
                    }

                    @Override
                    public void onFinish() {
                        imageButtonPlay.setVisibility(View.VISIBLE);
                    }
                };
                //trước khi chạy thì ẩn nút play
                imageButtonPlay.setVisibility(View.INVISIBLE);
                countDownTimer.start();
            }
        });


    }

    private void anhXa() {
        seekBar1 = findViewById(R.id.seekBar1);
        seekBar2 = findViewById(R.id.seekBar2);
        seekBar3 = findViewById(R.id.seekBar3);
        seekBar4 = findViewById(R.id.seekBar4);

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);

        textViewDiem = findViewById(R.id.textViewDiem);

        imageButtonPlay = findViewById(R.id.imageButtonPlay);
    }
}
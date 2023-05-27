package com.example.cuocduakythu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar1, seekBar2, seekBar3, seekBar4;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    TextView textViewDiem;
    ImageButton imageButtonPlay;
    Random r;
    int min, max, diem = 100, diemCong = 25, diemTru = 5;

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
                //không đặt cược thì không cho chơi
                if(!(checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked() || checkBox4.isChecked())){
                    Toast.makeText(MainActivity.this, "Bui lòng đặt cực trước khi chơi", Toast.LENGTH_SHORT).show();
                    return;
                }
                //khi đã vào đua thì không được thay đổi chọn và progress của seekbar
                tatHetSeekBar();
                tatHetCheckBox();

                //trước khi chạy reset về 0 hết
                seekBar1.setProgress(0);
                seekBar2.setProgress(0);
                seekBar3.setProgress(0);
                seekBar4.setProgress(0);
                CountDownTimer countDownTimer = new CountDownTimer(10000, 70) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int r1 = r.nextInt(max - min + 1) + min;
                        int r2 = r.nextInt(max - min + 1) + min;
                        int r3 = r.nextInt(max - min + 1) + min;
                        int r4 = r.nextInt(max - min + 1) + min;

                        //trước khi tiến tới kiểm tra xem đã về địch chưa để thông báo và dừng lại, và hiện nút play để chơi tiếp
                        if(seekBar1.getProgress() >= seekBar1.getMax()){
                            //nếu có chọn nhân vật thắng thì cộng điểm ngược lại thì trừ
                            if(checkBox1.isChecked())
                                diem += 25;
                            else
                                diem -= 5;
                            textViewDiem.setText("Điểm: " + diem);
                            Toast.makeText(MainActivity.this, "Siêu nhân đỏ win", Toast.LENGTH_SHORT).show();
                            imageButtonPlay.setVisibility(View.VISIBLE);
                            //khi có kết quả thì bật lại checkbox cho người chơi cược tiếp
                            batHetCheckBox();
                            this.cancel();
                            return;
                        }
                        if(seekBar2.getProgress() >= seekBar2.getMax()){
                            //nếu có chọn nhân vật thắng thì cộng điểm ngược lại thì trừ
                            if(checkBox2.isChecked())
                                diem += 25;
                            else
                                diem -= 5;
                            textViewDiem.setText("Điểm: " + diem);
                            Toast.makeText(MainActivity.this, "Tàu win", Toast.LENGTH_SHORT).show();
                            imageButtonPlay.setVisibility(View.VISIBLE);
                            //khi có kết quả thì bật lại checkbox cho người chơi cược tiếp
                            batHetCheckBox();
                            this.cancel();
                            return;
                        }
                        if(seekBar3.getProgress() >= seekBar3.getMax()){
                            //nếu có chọn nhân vật thắng thì cộng điểm ngược lại thì trừ
                            if(checkBox3.isChecked())
                                diem += 25;
                            else
                                diem -= 25;
                            textViewDiem.setText("Điểm: " + diem);
                            Toast.makeText(MainActivity.this, "Rùa win", Toast.LENGTH_SHORT).show();
                            imageButtonPlay.setVisibility(View.VISIBLE);
                            //khi có kết quả thì bật lại checkbox cho người chơi cược tiếp
                            batHetCheckBox();
                            this.cancel();
                            return;
                        }
                        if(seekBar4.getProgress() >= seekBar4.getMax()){
                            //nếu có chọn nhân vật thắng thì cộng điểm ngược lại thì trừ
                            if(checkBox4.isChecked())
                                diem += 5;
                            else
                                diem -= 5;
                            textViewDiem.setText("Điểm: " + diem);
                            Toast.makeText(MainActivity.this, "Thỏ win", Toast.LENGTH_SHORT).show();
                            imageButtonPlay.setVisibility(View.VISIBLE);
                            //khi có kết quả thì bật lại checkbox cho người chơi cược tiếp
                            batHetCheckBox();
                            this.cancel();
                            return;
                        }

                        seekBar1.setProgress(seekBar1.getProgress() + r1);
                        seekBar2.setProgress(seekBar2.getProgress() + r2);
                        seekBar3.setProgress(seekBar3.getProgress() + r3);
                        seekBar4.setProgress(seekBar4.getProgress() + r4);
                    }

                    @Override
                    public void onFinish() {
                        //lặp vô hạn đến khi thắng thì thoi
                        this.start();
                    }
                };
                //trước khi chạy thì ẩn nút play
                imageButtonPlay.setVisibility(View.INVISIBLE);
                countDownTimer.start();
            }
        });

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                    checkBox4.setChecked(false);
                }
            }
        });

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBox1.setChecked(false);
                    checkBox3.setChecked(false);
                    checkBox4.setChecked(false);
                }
            }
        });

        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                    checkBox4.setChecked(false);
                }
            }
        });

        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                }
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

    public void tatHetCheckBox(){
        checkBox1.setEnabled(false);
        checkBox2.setEnabled(false);
        checkBox3.setEnabled(false);
        checkBox4.setEnabled(false);
    }

    public void batHetCheckBox(){
        checkBox1.setEnabled(true);
        checkBox2.setEnabled(true);
        checkBox3.setEnabled(true);
        checkBox4.setEnabled(true);
    }

    public void tatHetSeekBar(){
        seekBar1.setEnabled(false);
        seekBar2.setEnabled(false);
        seekBar3.setEnabled(false);
        seekBar4.setEnabled(false);
    }

    public void batHetSeekBar(){
        seekBar1.setEnabled(true);
        seekBar2.setEnabled(true);
        seekBar3.setEnabled(true);
        seekBar4.setEnabled(true);
    }
}
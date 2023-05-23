package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroupThoiGian;
    RadioButton radioButtonSang, radioButtonTrua, radioButtonChieu;
    Button btnXacNhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        radioGroupThoiGian.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //i trả về id của radio button được check
                if(checkedId == R.id.radioButtonSang)
                    Toast.makeText(MainActivity.this, "Bạn đã chọn sáng", Toast.LENGTH_SHORT).show();
                else if(checkedId == R.id.radioButtonTrua)
                    Toast.makeText(MainActivity.this, "Bạn đã chọn trưa", Toast.LENGTH_SHORT).show();
                else if(checkedId == R.id.radioButtonChieu)
                    Toast.makeText(MainActivity.this, "Bạn đã chọn chiều", Toast.LENGTH_SHORT).show();
            }
        });

        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioButtonSang.isChecked())
                    Toast.makeText(MainActivity.this, "Bạn đã xác nhận buổi sáng", Toast.LENGTH_SHORT).show();
                else if(radioButtonTrua.isChecked())
                    Toast.makeText(MainActivity.this, "Bạn đã xác nhận buổi trưa", Toast.LENGTH_SHORT).show();
                else if(radioButtonChieu.isChecked())
                    Toast.makeText(MainActivity.this, "Bạn đã xác nhận buổi chiều", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Vui lòng chọn trước khi xác nhận", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void AnhXa() {
        radioGroupThoiGian = findViewById(R.id.RadioGroupThoiGian);
        radioButtonSang = findViewById(R.id.radioButtonSang);
        radioButtonTrua = findViewById(R.id.radioButtonTrua);
        radioButtonChieu = findViewById(R.id.radioButtonChieu);
        btnXacNhan = findViewById(R.id.buttonXacNhan);
    }
}
package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cbAndroid, cbPHP, cbASBDotNet;
    Button btnXacNhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        cbAndroid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Toast.makeText(MainActivity.this, "Bạn đã chọn adnroid", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Bạn đã bỏ chọn android", Toast.LENGTH_SHORT).show();
            }
        });
        
        cbPHP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Toast.makeText(MainActivity.this, "Bạn đã chọn PHP", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Bạn đã bỏ chọn PHP", Toast.LENGTH_SHORT).show();
            }
        });
        
        cbASBDotNet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Toast.makeText(MainActivity.this, "Bạn đã chọn ASB .net", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Bạn đã bỏ chọn ASB .net", Toast.LENGTH_SHORT).show();
            }
        });

        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monDaChon = "";
                if(cbAndroid.isChecked())
                    monDaChon += "Android \n";
                if(cbPHP.isChecked())
                    monDaChon += "PHP\n";
                if(cbASBDotNet.isChecked())
                    monDaChon += "ASB .net";
                if(monDaChon.length() == 0)
                    monDaChon = "Bạn chưa chọn môn nào";
                else
                    monDaChon = "Bạn đã chọn môn: \n" + monDaChon;
                Toast.makeText(MainActivity.this, monDaChon, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void AnhXa() {
        cbAndroid = findViewById(R.id.checkBox);
        cbPHP = findViewById(R.id.checkBox2);
        cbASBDotNet = findViewById(R.id.checkBox3);
        btnXacNhan = findViewById(R.id.button);
    }
}
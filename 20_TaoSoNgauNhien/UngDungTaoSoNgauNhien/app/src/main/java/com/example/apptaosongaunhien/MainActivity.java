package com.example.apptaosongaunhien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtKQ;
    EditText edtMin, edtMax;
    Button btnRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chuoi1 = edtMin.getText().toString(),
                chuoi2 = edtMax.getText().toString();
                if(chuoi1 == null || chuoi2 == null || chuoi1.length() == 0 || chuoi2.length() == 0){
                    Toast.makeText(MainActivity.this, "Không được bỏ trống", Toast.LENGTH_SHORT).show();
                    return;
                }
                int min = Integer.parseInt(chuoi1);
                int max = Integer.parseInt(chuoi2);
                if(min > max){
                    int temp = min;
                    min = max;
                    max = temp;
                }
                Random r = new Random();
                txtKQ.setText((r.nextInt(max - min + 1) + min) + "");
            }
        });
    }

    public void anhXa(){
        txtKQ = findViewById(R.id.textView);
        edtMin = findViewById(R.id.editTextText);
        edtMax = findViewById(R.id.editTextText2);
        btnRandom = findViewById(R.id.button);
    }
}
package com.example.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnSetChuoi, btnLayChuoi;
    EditText edtNoiDung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ánh xạ
        btnSetChuoi = (Button) findViewById(R.id.button);
        btnLayChuoi = (Button) findViewById(R.id.button2);
        edtNoiDung = (EditText) findViewById(R.id.editTextText);

        btnSetChuoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtNoiDung.setText("Set text thành công");
            }
        });

        btnLayChuoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, edtNoiDung.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
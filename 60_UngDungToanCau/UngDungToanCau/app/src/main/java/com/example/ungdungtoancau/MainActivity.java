package com.example.ungdungtoancau;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtThongTin;
    EditText editTextHoTen, editTextEmail, editTextSDT;
    Button btnXacNhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoTen = editTextHoTen.getText().toString(),
                email = editTextEmail.getText().toString(),
                sdt = editTextSDT.getText().toString();

//                Toast.makeText(MainActivity.this, "Chào bạn: " + hoTen + "\nEmail: " + email + "\nSố điện thoại: " + sdt, Toast.LENGTH_SHORT).show();
                txtThongTin.setText("Chào bạn: " + hoTen + "\nEmail: " + email + "\nSố điện thoại: " + sdt);
            }
        });
    }

    private void anhXa() {
        txtThongTin = findViewById(R.id.txtThongTin);
        editTextHoTen = findViewById(R.id.editTextTextHoTen);
        editTextEmail = findViewById(R.id.editTextTextEmail);
        editTextSDT = findViewById(R.id.editTextTextSDT);
        btnXacNhan = findViewById(R.id.btnXacNhan);
    }
}
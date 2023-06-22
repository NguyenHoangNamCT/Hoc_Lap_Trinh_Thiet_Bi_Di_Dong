package com.example.celendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewTime);

        //thư viện java.util
        Calendar calendar = Calendar.getInstance();

//        textView.setText(calendar.getTime().toString());
        textView.append(calendar.getTime() + "\n");
        textView.append(calendar.get(Calendar.DATE) + "\n");
        textView.append(calendar.get(Calendar.MONTH) + 1 + "\n");
        textView.append(calendar.get(Calendar.YEAR) + 1 + "\n");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        textView.append(simpleDateFormat.format(calendar.getTime()) + "\n");

        textView.append(calendar.get(Calendar.HOUR) + "\n");
        textView.append(calendar.get(Calendar.HOUR_OF_DAY) + "\n");

        SimpleDateFormat dinhDangGio = new SimpleDateFormat("hh:mm:ss a");
        textView.append(dinhDangGio.format(calendar.getTime()) + "\n");
    }
}
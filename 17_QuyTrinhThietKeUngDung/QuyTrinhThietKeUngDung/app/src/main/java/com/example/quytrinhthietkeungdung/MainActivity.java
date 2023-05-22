package com.example.quytrinhthietkeungdung;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ánh xạ
        textView = (TextView) findViewById(R.id.Hello);


        //viết code
        textView.setText("Lập trình android");
    }
}
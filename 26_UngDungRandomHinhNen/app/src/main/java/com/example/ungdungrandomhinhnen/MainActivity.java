package com.example.ungdungrandomhinhnen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout myConstraintLayout;
    Button btn;
    TextView txt;
    ArrayList<Integer> imgArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myConstraintLayout = findViewById(R.id.myConstraintLayout);
        btn = findViewById(R.id.button);
        txt = findViewById(R.id.textView);

        imgArr = new ArrayList<>();

        imgArr.add(R.drawable.anhnentonexanh);
        imgArr.add(R.drawable.background);
        imgArr.add(R.drawable.background2);
        imgArr.add(R.drawable.background3);
        imgArr.add(R.drawable.background4);

        Random r = new Random();

        myConstraintLayout.setBackgroundResource(imgArr.get(r.nextInt(imgArr.size())));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myConstraintLayout.setBackgroundResource(imgArr.get(r.nextInt(imgArr.size())));
            }
        });

    }
}
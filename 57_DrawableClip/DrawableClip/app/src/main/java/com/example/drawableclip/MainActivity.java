package com.example.drawableclip;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ánh xạ
        imageView = findViewById(R.id.imageView);
        btn = findViewById(R.id.button);

        final ClipDrawable clipDrawable = (ClipDrawable) imageView.getDrawable(); //Dòng này để lấy image level

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postAtTime(new Runnable() {
                    @Override
                    public void run() {
                        int drawableLevel = clipDrawable.getLevel();
                        if(drawableLevel >= 10000)
                            drawableLevel = 0;
                        imageView.setImageLevel(drawableLevel + 1000);
                        handler.postDelayed(this, 500);
                    }
                }, 1000);
            }
        });
    }
}
package com.example.menukhoitao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuSettings){
            Toast.makeText(this, "Bạn chọn setting", Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId() == R.id.menuEmail){
            Toast.makeText(this, "Bạn chọn email", Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId() == R.id.menuPhone){
            Toast.makeText(this, "Bạn chọn phone", Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId() == R.id.menuSearch){
            Toast.makeText(this, "Bạn chọn search", Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId() == R.id.menuShare){
            Toast.makeText(this, "Bạn chọn share", Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId() == R.id.menuExit){
            Toast.makeText(this, "Bạn chọn exit", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
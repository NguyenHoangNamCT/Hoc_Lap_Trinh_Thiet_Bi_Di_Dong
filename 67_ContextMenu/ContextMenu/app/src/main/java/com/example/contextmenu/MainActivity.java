package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.view.ContextMenu; // phải import với có phương thức onCreateContextMenu

public class MainActivity extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //anh xa
        constraintLayout = findViewById(R.id.constraintLayout);
        btn = findViewById(R.id.button);


        //đăng ký view cho context menu
        registerForContextMenu(btn);

    }

    //phương thức để bắt sự kiện hiển thị menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);

        menu.setHeaderTitle("Chọn màu");

        menu.setHeaderIcon(R.mipmap.ic_launcher);

        super.onCreateContextMenu(menu, v, menuInfo);

    }

    //phương thức để bắt sự kiện cho item trong context menu
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuDo){
            constraintLayout.setBackgroundColor(Color.RED);
        } else if(item.getItemId() == R.id.menuXanhg){
            constraintLayout.setBackgroundColor(Color.BLUE);
        } else if(item.getItemId() == R.id.menuVang){
            constraintLayout.setBackgroundColor(Color.YELLOW);
        }
        return super.onContextItemSelected(item);
    }
}
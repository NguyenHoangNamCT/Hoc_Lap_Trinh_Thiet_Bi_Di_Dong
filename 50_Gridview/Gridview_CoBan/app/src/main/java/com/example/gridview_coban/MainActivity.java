package com.example.gridview_coban;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    String bangChuCai[] = new String[26];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //gán giá trị cho mảng String bangChuCai là một bảng chữ cái
        char firstChar = 'A';
        for(int i = 0; i < bangChuCai.length; i++){
            bangChuCai[i] = String.valueOf(firstChar);
            firstChar++;
        }

        //ánh xạ
        gridView = findViewById(R.id.gridViewBangChuCai);

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, bangChuCai);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Index: " + position + ". Value: " + bangChuCai[position], Toast.LENGTH_SHORT).show();
            }
        });

    }
}
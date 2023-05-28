package com.example.listview_coban;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvMonHoc;
    ArrayList<String> courseArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMonHoc = findViewById(R.id.listView);

        courseArrayList = new ArrayList<>();
        courseArrayList.add("Android");
        courseArrayList.add("IOS");
        courseArrayList.add("Web");
        courseArrayList.add("Asb.net");
        courseArrayList.add("Unity");

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, courseArrayList);

        lvMonHoc.setAdapter(adapter);
    }
}
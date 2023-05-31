package com.example.gridview_nangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<HinhAnh> imageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridViewHinhAnh);

        ganGiaTriChoMangHinh();

        ImageAdapter imageAdapter = new ImageAdapter(MainActivity.this, R.layout.item_gridview, imageList);

        gridView.setNumColumns(3);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Mô tả của hình ảnh: " + imageList.get(position).getMoTa(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void ganGiaTriChoMangHinh(){
        imageList = new ArrayList<>();
        imageList.add(new HinhAnh(R.drawable.gridview1, "Hình goku"));
        imageList.add(new HinhAnh(R.drawable.gridview2, "Hình mèo chơi laptop"));
        imageList.add(new HinhAnh(R.drawable.gridview3, "Hình ruộng bậc thang"));
        imageList.add(new HinhAnh(R.drawable.gridview4, "Hình chã lụa"));
        imageList.add(new HinhAnh(R.drawable.gridview5, "Hình mèo trắng"));
        imageList.add(new HinhAnh(R.drawable.gridview6, "Hình mèo 2d"));
        imageList.add(new HinhAnh(R.drawable.gridview7, "Hình hình con ma cute"));
        imageList.add(new HinhAnh(R.drawable.gridview8, "Hình cậu vàng"));
        imageList.add(new HinhAnh(R.drawable.gridview9, "Hình mèo ok"));
        imageList.add(new HinhAnh(R.drawable.gridview10, "Hình cây hoa vàng"));

    }
}
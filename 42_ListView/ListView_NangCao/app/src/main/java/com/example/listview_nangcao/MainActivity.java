package com.example.listview_nangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView fruitListView;
    ArrayList<TraiCay> fruitArrayList;
    TraiCayAdapter fruitAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ánh xạ
        fruitListView = findViewById(R.id.listViewTraiCay);
        fruitArrayList = new ArrayList<>();
        themGiaTriChoFruitArrayList();

        fruitAdapter = new TraiCayAdapter(this, R.layout.dong_trai_cay, fruitArrayList);
        fruitListView.setAdapter(fruitAdapter);
    }

    public void themGiaTriChoFruitArrayList(){
        fruitArrayList.add(new TraiCay("Bơ", "Bơ mất zin", R.drawable.traibo));
        fruitArrayList.add(new TraiCay("Đào tiên", "Ăn dô thành tiên luôn", R.drawable.traidaotien));
        fruitArrayList.add(new TraiCay("Dây tây", "Dâu bên tây", R.drawable.traidautay));
        fruitArrayList.add(new TraiCay("Măng cụt", "Đây là trái măng cụt", R.drawable.traimangcut));
        fruitArrayList.add(new TraiCay("Sầu riêng", "Vua trái cây", R.drawable.traisaurieng));
    }
}
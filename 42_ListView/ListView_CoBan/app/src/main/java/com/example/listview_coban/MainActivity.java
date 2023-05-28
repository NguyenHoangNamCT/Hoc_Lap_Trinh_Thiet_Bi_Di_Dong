package com.example.listview_coban;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvMonHoc;
    ArrayList<String> courseArrayList;
    EditText editTextNoiDung;
    Button btnThem, btnSua;
    int positionClick = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        courseArrayList = new ArrayList<>();
        courseArrayList.add("Android");
        courseArrayList.add("IOS");
        courseArrayList.add("Web");
        courseArrayList.add("Asb.net");
        courseArrayList.add("Unity");

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, courseArrayList);

        lvMonHoc.setAdapter(adapter);

        //Khi click vào item sẽ gán giá trị của item đó lên editText ở trên
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                editTextNoiDung.setText(courseArrayList.get(position));
                positionClick = position;
                Toast.makeText(MainActivity.this, "Click" + position + ": " + courseArrayList.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Xoá thành công", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "Long click: " + position + ": " + courseArrayList.get(position), Toast.LENGTH_SHORT).show();
                courseArrayList.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                courseArrayList.add(editTextNoiDung.getText().toString());
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                courseArrayList.set(positionClick, editTextNoiDung.getText().toString());
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void anhXa() {
        lvMonHoc = findViewById(R.id.listView);
        btnSua = findViewById(R.id.buttonSua);
        btnThem = findViewById(R.id.buttonThem);
        editTextNoiDung = findViewById(R.id.editTextText);
    }
}
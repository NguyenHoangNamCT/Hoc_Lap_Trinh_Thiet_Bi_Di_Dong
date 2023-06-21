package com.example.customdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewLogin);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogLogin();
            }
        });
    }

    private void dialogLogin(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_custom);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // tắt tittle mặt định đi nhưng phiên bản mới tắt sản rồi
//        dialog.setCanceledOnTouchOutside(true); //khi người ta click ra ngoài không tắt dialog mà mình k thích cái này:D
//        dialog.setTitle("Đăng nhập hệ thống"); //để tên tiêu đề mặt định là đăng nhập hệ thống


        //ánh xạ từ dialog custom
        EditText editTextTDN = dialog.findViewById(R.id.edtTDN);
        EditText editTextPW = dialog.findViewById(R.id.edtPW);
        Button btnDangNhap = dialog.findViewById(R.id.buttonDangNhap);
        Button btnHuy = dialog.findViewById(R.id.buttonHuy);

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                dialog.dismiss();
                dialog.cancel();
            }
        });

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tdn = editTextTDN.getText().toString().trim();
                String pw = editTextPW.getText().toString().trim();
                if(tdn.equals("admin") && pw.equals("123")){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
//                    dialog.cancel();
                }
                else
                    Toast.makeText(MainActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();

            }
        });

        dialog.show();
    }
}
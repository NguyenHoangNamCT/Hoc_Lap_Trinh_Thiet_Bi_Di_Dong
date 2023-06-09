package com.example.listview_coban;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TraiCayAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<TraiCay> fruitList;

    @Override
    public int getCount() {
        return fruitList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(layout, null);

        //ánh xạ
        TextView ten = convertView.findViewById(R.id.textViewTen),
                mota = convertView.findViewById(R.id.textViewMoTa);
        ImageView hinhTraiCay= convertView.findViewById(R.id.imageViewTraiCay);

        ten.setText(fruitList.get(position).getTen());
        mota.setText(fruitList.get(position).getMoTa());
        hinhTraiCay.setImageResource(fruitList.get(position).getHinhAnh());
        return convertView;
    }
}

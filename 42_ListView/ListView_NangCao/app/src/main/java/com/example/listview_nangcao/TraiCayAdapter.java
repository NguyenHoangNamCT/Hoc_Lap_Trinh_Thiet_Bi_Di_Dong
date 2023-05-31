package com.example.listview_nangcao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Vector;

public class TraiCayAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<TraiCay> fruitList;

    public TraiCayAdapter(Context context, int layout, List<TraiCay> fruitList) {
        this.context = context;
        this.layout = layout;
        this.fruitList = fruitList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public List<TraiCay> getFruitList() {
        return fruitList;
    }

    public void setFruitList(List<TraiCay> fruitList) {
        this.fruitList = fruitList;
    }

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

    class ViewHolder{
        ImageView img;
        TextView tvMoTa, tvTen;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout, null);

            viewHolder = new ViewHolder();
            //ánh xạ
            viewHolder.tvTen = convertView.findViewById(R.id.textViewTen);
            viewHolder.tvMoTa = convertView.findViewById(R.id.textViewMoTa);
            viewHolder.img= convertView.findViewById(R.id.imageViewTraiCay);

            //setTag (lưu đối tượng viewHolder lại)
            convertView.setTag(viewHolder);
        }
        else{
            //lấy đối tượng đã lưu ra
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.tvTen.setText(fruitList.get(position).getTen());
        viewHolder.tvMoTa.setText(fruitList.get(position).getMoTa());
        viewHolder.img.setImageResource(fruitList.get(position).getHinhAnh());
        return convertView;
    }
}

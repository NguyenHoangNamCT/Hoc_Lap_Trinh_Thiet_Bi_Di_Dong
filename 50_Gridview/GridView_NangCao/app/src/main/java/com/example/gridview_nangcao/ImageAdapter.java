package com.example.gridview_nangcao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<HinhAnh> imageList;

    public ImageAdapter(Context context, int layout, List<HinhAnh> imageList) {
        this.context = context;
        this.layout = layout;
        this.imageList = imageList;
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

    public List<HinhAnh> getImageList() {
        return imageList;
    }

    public void setImageList(List<HinhAnh> imageList) {
        this.imageList = imageList;
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    class ViewHolder {
        ImageView img;
        TextView textViewMoTa;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout, null);

            viewHolder = new ViewHolder();
            //ánh xạ
            viewHolder.img = convertView.findViewById(R.id.imageView_ItemGridView);
            viewHolder.textViewMoTa = convertView.findViewById(R.id.textView_ItemGridview);
            //lưu đối tượng viewHolder vào converView
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.img.setImageResource(imageList.get(position).getHinh());
        viewHolder.textViewMoTa.setText(imageList.get(position).getMoTa());
        return convertView;
    }
}

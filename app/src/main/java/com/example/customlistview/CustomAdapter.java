package com.example.customlistview;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    Context context;
    String[] Tittle;
    String[] Subtittle;
    int[] image;
    LayoutInflater inflater;

    public CustomAdapter(Context context, String[] title, String[] subTitle, int[] image) {
        this.context = context;
        this.Tittle = title;
        this.Subtittle = subTitle;
        this.image = image;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return Tittle.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.base_adapter_layout, null);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.tv_Tittle);
        TextView textView1 = (TextView) convertView.findViewById(R.id.tv_Subtittle);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.ImageView);

        textView.setText(Tittle[position]);
        textView1.setText(Subtittle[position]);
        imageView.setImageResource(image[position]);

        return convertView;
    }
}



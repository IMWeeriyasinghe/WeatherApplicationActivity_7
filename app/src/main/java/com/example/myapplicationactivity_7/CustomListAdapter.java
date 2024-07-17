package com.example.myapplicationactivity_7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] itemname;
    private final int[] image_id;

    public CustomListAdapter(Context context, String[] itemname, int[] image_id) {
        super(context, R.layout.my_list, itemname);
        this.context = context;
        this.itemname = itemname;
        this.image_id = image_id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.my_list, parent, false);

        ImageView imageView = rowView.findViewById(R.id.icon);
        TextView textView = rowView.findViewById(R.id.item_name);

        imageView.setImageResource(image_id[position]);
        textView.setText(itemname[position]);

        return rowView;
    }
}

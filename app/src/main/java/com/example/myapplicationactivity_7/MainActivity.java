package com.example.myapplicationactivity_7;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView list;
    String[] text_list = {
            "nm to mm",
            "mm to nm",
            "mm to cm",
            "cm to mm",
            "cm to m",
            "m to cm",
            "m to km",
    };

    int[] icon_list = {
            R.drawable.pic_1,
            R.drawable.pic_2,
            R.drawable.pic_3,
            R.drawable.pic_4,
            R.drawable.pic_5,
            R.drawable.pic_1,
            R.drawable.pic_2,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list_view);

        // Inflate the header layout and add it to the ListView
        LayoutInflater inflater = getLayoutInflater();
        View headerView = inflater.inflate(R.layout.header_layout, listView, false);
        listView.addHeaderView(headerView);

        CustomListAdapter adapter = new CustomListAdapter(this, text_list, icon_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Adjust position to account for the header view
                int adjustedPosition = position - listView.getHeaderViewsCount();
                if (adjustedPosition >= 0 && adjustedPosition < text_list.length) {
                    Toast.makeText(MainActivity.this, "Clicked: " + text_list[adjustedPosition], Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

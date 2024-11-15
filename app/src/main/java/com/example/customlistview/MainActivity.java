package com.example.customlistview;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ListView;
//import android.widget.Toast;
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//
//public class MainActivity extends AppCompatActivity {
//
//    private ListView listView;
//    String[] title;
//    String[] subTitle;
//    private int[] image = {R.drawable.fb, R.drawable.youtube, R.drawable.twitter, R.drawable.linkedin, R.drawable.messenger, R.drawable.whatsapp};
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//
//        title = getResources().getStringArray(R.array.title_names);
//        subTitle = getResources().getStringArray(R.array.subtitle_names);
//
//        listView = findViewById(R.id.listviewId);
//
//        CustomAdapter adapter = new CustomAdapter(this, title, subTitle, image);
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Toast.makeText(MainActivity.this, "Clicked: " + position, Toast.LENGTH_SHORT).show();
//
//                Intent intent = new Intent(MainActivity.this, ItemListViewActivity.class);
//                intent.putExtra("Title", title[position]);
//                intent.putExtra("Subtitle", subTitle[position]);
//                intent.putExtra("Image", image[position]);
//                startActivity(intent);
//            }
//        });
//    }
//}
//
//
//




import android.os.Bundle;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> listGroupTitles;
    private HashMap<String, List<String>> listChildItems;
    private int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = findViewById(R.id.expandableListView);
        initData();

        int[] groupImages = {
                R.drawable.fb, R.drawable.youtube, R.drawable.twitter,
                R.drawable.linkedin, R.drawable.messenger, R.drawable.whatsapp
        };

        expandableListAdapter = new ExpandableListAdapter(this, listGroupTitles, listChildItems,groupImages);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupExpandListener(groupPosition -> {
            if (lastExpandedPosition != -1 && groupPosition != lastExpandedPosition) {
                expandableListView.collapseGroup(lastExpandedPosition);
            }
            lastExpandedPosition = groupPosition;
        });

        expandableListView.setOnGroupCollapseListener(groupPosition -> {
            if (lastExpandedPosition == groupPosition) {
                lastExpandedPosition = -1;
            }
        });
    }

    private void initData() {
        String[] groupTitles = getResources().getStringArray(R.array.title_names);
        String[] childDescriptions = getResources().getStringArray(R.array.platform_descriptions);

        listGroupTitles = new ArrayList<>();
        listChildItems = new HashMap<>();

        for (int i = 0; i < groupTitles.length; i++) {
            listGroupTitles.add(groupTitles[i]);
            List<String> childList = new ArrayList<>();
            childList.add(childDescriptions[i]);
            listChildItems.put(groupTitles[i], childList);
        }
    }
}





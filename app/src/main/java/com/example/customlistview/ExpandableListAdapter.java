package com.example.customlistview;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listGroupTitles;
    private HashMap<String, List<String>> listChildItems;
    private int[] groupImages;

    public ExpandableListAdapter(Context context, List<String> listGroupTitles,
                                 HashMap<String, List<String>> listChildItems, int[] groupImages) {
        this.context = context;
        this.listGroupTitles = listGroupTitles;
        this.listChildItems = listChildItems;
        this.groupImages = groupImages;
    }

    @Override
    public int getGroupCount() {
        return listGroupTitles.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listChildItems.get(listGroupTitles.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listGroupTitles.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listChildItems.get(listGroupTitles.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_group_with_image, parent, false);
        }

        TextView groupTitleTextView = convertView.findViewById(R.id.groupTitleTextView);
        ImageView groupImageView = convertView.findViewById(R.id.groupImageView);

        groupTitleTextView.setText(listGroupTitles.get(groupPosition));
        groupImageView.setImageResource(groupImages[groupPosition]);  // Set the image for the group

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        TextView childTextView = (TextView) convertView.findViewById(android.R.id.text1);
        childTextView.setText(listChildItems.get(listGroupTitles.get(groupPosition)).get(childPosition));

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}






package com.example.merveerdem.yourguide;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class AccommodationAdapter extends BaseExpandableListAdapter {

    private Context ctx;
    private HashMap<String, List<String>> Accommodation_Category;
    private List<String> Accommodation_List;

    public AccommodationAdapter(Context ctx, HashMap<String, List<String>> Movies_Category, List<String> Movies_List){
        this.ctx=ctx;
        this.Accommodation_Category=Movies_Category;
        this.Accommodation_List=Movies_List;
    }

    @Override
    public int getGroupCount() {
        //returns actual number of list available in movies list
        return Accommodation_List.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        //this will return the number of subtitles available in each list
        return Accommodation_Category.get(Accommodation_List.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        //return the number of group available in that listview
        return Accommodation_List.get(groupPosition);
    }

    @Override
    public Object getChild(int parent, int child) {
        //this will return the current child as object
        return Accommodation_Category.get(Accommodation_List.get(parent)).get(child);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int parent, int child) {
        return child;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int parent, boolean isExpanded, View convertView, ViewGroup parentView) {
        String group_title=(String)getGroup(parent);
        if (convertView == null)
        {
            LayoutInflater inflator = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflator.inflate(R.layout.parent_layout_expandable_list_view, parentView, false);
        }
        TextView parent_textview= (TextView) convertView.findViewById(R.id.parent_txt);
        parent_textview.setTypeface(null, Typeface.BOLD);
        parent_textview.setText(group_title);
        return convertView;
    }

    @Override
    public View getChildView(int parent, int child, boolean lastChild, View convertView, ViewGroup parentView) {
        //this method actually make the view for each child appearance
        //that means  each sub category
        String child_title = (String)getChild(parent,child); //this will return current title of the child
        if (convertView == null)
        {
            LayoutInflater inflator = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflator.inflate(R.layout.child_layout_expandable_list_view,parentView,false);
        }
        TextView child_textview = convertView.findViewById(R.id.child_txt);
        child_textview.setText(child_title);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

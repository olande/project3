package com.example.waste;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Hero> {
    private List<Hero>heroList;

    private Context context;

    public ListViewAdapter(List<Hero>heroList,Context context) {

        super(context, R.layout.list_items,heroList);

        this.heroList=heroList;
        this.context=context;

    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.list_items, null, true);
        TextView userId=listViewItem.findViewById(R.id.userId);
        TextView  Binno=listViewItem.findViewById(R.id.Binno);
        TextView Location= listViewItem.findViewById(R.id.Location);
        TextView Complaints=listViewItem.findViewById(R.id.Complaints);
        TextView Time= listViewItem.findViewById(R.id.Time);
        Hero hero= heroList.get(position);

        userId.setText(hero.getUserid());
        Location.setText(hero.getLocation());
        Complaints.setText(hero.getComplaints());
        Time.setText(hero.getTime());
        Binno.setText(hero.getBinno());
        return listViewItem;
    }
}
